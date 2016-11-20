package Service.Replication;

import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by berkinguler on 20/11/2016.
 */
public class ChainReplication extends ReplicationStrategy {

    public ChainReplication(Socket client, LinkedList<String> replicaList) {
        super(client, replicaList);
    }
}
