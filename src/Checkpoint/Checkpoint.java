package Checkpoint;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Berkin GÜLER (bguler15@ku.edu.tr) on 14.11.2016.
 */
public interface Checkpoint {
    byte[] createCheckpoint(ConcurrentHashMap<String, String> database);
}
