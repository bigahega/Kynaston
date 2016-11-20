package Checkpoint;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Berkin GÜLER (bguler15@ku.edu.tr) on 14.11.2016.
 */
public class IncrementalCheckpoint extends BaseCheckpoint implements Checkpoint {

    private ConcurrentHashMap<String, String> previousDatabase;

    @Override
    public byte[] createCheckpoint(ConcurrentHashMap<String, String> database) {
        if(this.previousDatabase == null || this.previousDatabase.size() == 0 ) {
            this.previousDatabase = database;
            return this.hashmapToByteArray(database);
        }

        ConcurrentHashMap<String, String> difference = new ConcurrentHashMap<>();
        difference.putAll(this.previousDatabase);
        difference.putAll(database);
        difference.entrySet().removeAll(this.previousDatabase.entrySet());
        this.previousDatabase = database;

        return this.hashmapToByteArray(difference);
    }
}
