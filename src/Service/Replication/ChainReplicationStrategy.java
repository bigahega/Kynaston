package Service.Replication;

import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by berkinguler on 20/11/2016.
 */
public class ChainReplicationStrategy extends AbstractReplicationStrategy {

    private ArrayList<String> replicaList;

    public ChainReplicationStrategy(Socket client, ArrayList<String> replicaList) {
        this.replicaList = replicaList;
    }
}
