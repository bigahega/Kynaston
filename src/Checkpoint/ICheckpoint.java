package Checkpoint;

import Checkpoint.Compression.CompressionType;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Berkin GÜLER (bguler15@ku.edu.tr) on 14.11.2016.
 */
public interface ICheckpoint {
    byte[] createCheckpoint(ConcurrentHashMap<String, String> database);
}
