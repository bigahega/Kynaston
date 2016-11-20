package Checkpoint.Compression;

import com.github.luben.zstd.Zstd;

/**
 * Created by Berkin GÜLER (bguler15@ku.edu.tr) on 14.11.2016.
 */
public class ZStdCompressor implements Compressor {
    @Override
    public byte[] compress(byte[] in) {
        return Zstd.compress(in);
    }

    @Override
    public byte[] decompress(byte[] in) {
        long decompressedSize = Zstd.decompressedSize(in);
        if(decompressedSize > Integer.MAX_VALUE)
            return null;
        byte[] decompressedArray = new byte[(int) decompressedSize];
        Zstd.decompress(decompressedArray, in);
        return decompressedArray;
    }
}
