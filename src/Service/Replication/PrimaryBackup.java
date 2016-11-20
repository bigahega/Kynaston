package Service.Replication;

import Database.Kynaston;
import Service.TxObjects.Request;
import Service.TxObjects.RequestType;
import Service.TxObjects.Response;
import Service.TxObjects.ResponseType;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by berkinguler on 20/11/2016.
 */
public class PrimaryBackup extends ReplicationStrategy {

    private ArrayList<String> replicaList;
    private PrimaryBackupReplicaType replicaType;

    public PrimaryBackup(Socket client, List<String> replicaList, PrimaryBackupReplicaType replicaType) {
        super(client);
        this.replicaList = new ArrayList<>(replicaList);
        this.replicaType = replicaType;
    }

    @Override
    public void run() {
        switch (replicaType) {
            case PRIMARY:
                this.primaryWorker();
                break;
            case BACKUP:
                this.backupWorker();
                break;
        }
    }

    private void primaryWorker() {
        try(ObjectInput input = new ObjectInputStream(this.client.getInputStream())) {
            while(true) {
                Object requestObj = input.readObject();
                if(requestObj instanceof Integer && (int)requestObj == 0xDEADBABA) {
                    this.replicaList.parallelStream().forEach(this::killReplica);
                }
                else if(requestObj instanceof Request) {
                    Request request = (Request) requestObj;
                    String responseValue = null;
                    switch (request.getRequestType()) {
                        case READ:
                        case READALL:
                            responseValue = Kynaston.getInstance().query(request.getKey());
                            break;
                        case UPDATE:
                        case DELETE:
                            responseValue = Kynaston.getInstance().update(request.getKey(), request.getValue());
                            break;
                    }
                    HashMap<String, String> responseMap = new HashMap<>();
                    responseMap.put(request.getKey(), responseValue);
                    Response responseObj = new Response(ResponseType.RESULT, responseMap);

                    ObjectOutput outputObj = new ObjectOutputStream(this.client.getOutputStream());
                    outputObj.writeObject(responseObj);
                    outputObj.flush();
                    outputObj.close();
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void backupWorker() {

    }
}