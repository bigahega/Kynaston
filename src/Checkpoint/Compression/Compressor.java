package Checkpoint.Compression;

/**
 * Created by Berkin GÜLER (bguler15@ku.edu.tr) on 14.11.2016.
 */
public interface Compressor {

    byte[] compress(byte[] in);
    byte[] decompress(byte[] in);
}
