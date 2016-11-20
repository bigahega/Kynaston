package Checkpoint;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Berkin GÜLER (bguler15@ku.edu.tr) on 14.11.2016.
 */
public class FullCheckpoint extends BaseCheckpoint implements Checkpoint {
    @Override
    public byte[] createCheckpoint(ConcurrentHashMap<String, String> database) {
        return this.hashmapToByteArray(database);
    }
}
