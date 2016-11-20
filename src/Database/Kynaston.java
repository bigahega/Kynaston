package Database;

import Checkpoint.CheckpointFactory;
import Checkpoint.CheckpointType;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Berkin GÜLER (bguler15@ku.edu.tr) on 10.11.2016.
 */
public class Kynaston implements IKynaston {
    private static Kynaston ourInstance = new Kynaston();

    public static Kynaston getInstance() {
        return ourInstance;
    }

    private ConcurrentHashMap<String, String> database;

    private CheckpointType checkpointType;

    private Kynaston() {
        this.database = new ConcurrentHashMap<>();
    }

    @Override
    public String query(String key) {
        return this.database.get(key);
    }

    @Override
    public String update(String key, String value) {
        return this.database.putIfAbsent(key, value);
    }

    @Override
    public byte[] checkpoint() {
        return CheckpointFactory.getInstance().getCheckpoint(this.checkpointType).createCheckpoint(this.database);
    }

    public void setCheckpointType(CheckpointType checkpointType) {
        this.checkpointType = checkpointType;
    }
}
