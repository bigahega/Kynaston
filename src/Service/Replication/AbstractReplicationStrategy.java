package Service.Replication;

import Service.MainNetworkService;

import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by berkinguler on 20/11/2016.
 */
public abstract class AbstractReplicationStrategy extends Thread {

    Socket client;
    AbstractReplicationStrategy(Socket client) {
        this.client = client;
    }

    void killReplica(String replicaAddress) {
        try {
            Socket replicaConnection = new Socket(replicaAddress, MainNetworkService.networkPort);
            ObjectOutput killerObj = new ObjectOutputStream(replicaConnection.getOutputStream());
            killerObj.write(0xDEADBABA);
            replicaConnection.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
