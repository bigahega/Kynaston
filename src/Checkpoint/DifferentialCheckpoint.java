package Checkpoint;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Berkin GÜLER (bguler15@ku.edu.tr) on 14.11.2016.
 */
public class DifferentialCheckpoint extends BaseCheckpoint implements Checkpoint {
    private ConcurrentHashMap<String, String> initalDatabase;

    @Override
    public byte[] createCheckpoint(ConcurrentHashMap<String, String> database) {
        if(this.initalDatabase == null || this.initalDatabase.size() == 0) {
            this.initalDatabase = database;
            return this.hashmapToByteArray(database);
        }

        ConcurrentHashMap<String, String> difference = new ConcurrentHashMap<>();
        difference.putAll(this.initalDatabase);
        difference.putAll(database);
        difference.entrySet().removeAll(this.initalDatabase.entrySet());

        return this.hashmapToByteArray(difference);
    }
}
