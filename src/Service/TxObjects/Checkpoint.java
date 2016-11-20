package Service.TxObjects;

import java.io.Serializable;
import Checkpoint.CheckpointType;

/**
 * Created by berkinguler on 20/11/2016.
 */
public class Checkpoint implements Serializable {

    private final CheckpointType checkpointType;
    private final byte[] checkpointData;

    public Checkpoint(CheckpointType checkpointType, byte[] checkpointData) {
        this.checkpointType = checkpointType;
        this.checkpointData = checkpointData;
    }

    public CheckpointType getCheckpointType() {
        return checkpointType;
    }

    public byte[] getCheckpointData() {
        return checkpointData;
    }
}
