import Checkpoint.CheckpointType;
import Database.Kynaston;
import Service.MainNetworkService;
import Service.Replication.PrimaryBackupReplicaType;
import Utilities.Utilities;

import java.util.ArrayList;

/**
 * Created by berkinguler on 20/11/2016.
 */
public class MainKynaston {

    public static void main(String... args) {
        String replicaListFile = args[0];
        String replicaType = args[1];
        String checkpointType = args[2];

        ArrayList<String> replicaList = Utilities.readLinesToArrayList(replicaListFile);

        Kynaston.getInstance().setCheckpointType(Utilities.getEnumFromString(CheckpointType.class, checkpointType));

        MainNetworkService networkService = new MainNetworkService(replicaList,
                Utilities.getEnumFromString(PrimaryBackupReplicaType.class, replicaType));
        networkService.startService();
    }

}
