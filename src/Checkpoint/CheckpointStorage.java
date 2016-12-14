package Checkpoint;

import java.util.ArrayList;

/**
 * Created by Berkin GÜLER on 12.12.2016.
 */
public class CheckpointStorage {
    private static CheckpointStorage ourInstance = new CheckpointStorage();

    public static CheckpointStorage getInstance() {
        return ourInstance;
    }

    private ArrayList<byte[]> checkpointStore;

    private CheckpointStorage() {
        checkpointStore = new ArrayList<>();
    }

    public void addCheckpoint(byte[] checkpoint) {
        this.checkpointStore.add(checkpoint);
    }

    public void clearCheckpoints() {
        this.checkpointStore.clear();
    }

    public ArrayList<byte[]> getCheckpoints() {
        return this.checkpointStore;
    }
}
