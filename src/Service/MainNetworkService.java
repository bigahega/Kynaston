package Service;

import Service.Replication.PrimaryBackup;
import Service.Replication.PrimaryBackupReplicaType;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by berkinguler on 20/11/2016.
 */
public class MainNetworkService {

    public static int networkPort = 1881;
    private ServerSocket listenerSocket;
    private ArrayList<String> replicaList;
    private PrimaryBackupReplicaType replicaType;

    public MainNetworkService(ArrayList<String> replicaList, PrimaryBackupReplicaType replicaType) {
        this.replicaList = replicaList;
        this.replicaType = replicaType;
    }

    public void startService() {
        try {
            this.listenerSocket = new ServerSocket(networkPort);

            while(true) {
                Socket client = this.listenerSocket.accept();
                PrimaryBackup handler = new PrimaryBackup(client, replicaList, replicaType);
                handler.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}