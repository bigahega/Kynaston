package Checkpoint.Compression;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * Created by Berkin GÜLER (bguler15@ku.edu.tr) on 14.11.2016.
 */
public class DeflateCompressor implements Compressor {
    @Override
    public byte[] compress(byte[] in) {
        byte[] compressedBytes = null;

        Deflater compressor = new Deflater(Deflater.BEST_COMPRESSION);
        compressor.setInput(in);
        compressor.finish();

        try(ByteArrayOutputStream baos = new ByteArrayOutputStream(in.length)) {
            byte[] buf = new byte[1024];
            while(!compressor.finished()) {
                int count = compressor.deflate(buf);
                baos.write(buf, 0, count);
            }
            compressedBytes = baos.toByteArray();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return compressedBytes;
    }

    @Override
    public byte[] decompress(byte[] in) {
        byte[] decompressedBytes = null;

        Inflater decompressor = new Inflater();
        decompressor.setInput(in);

        try(ByteArrayOutputStream baos = new ByteArrayOutputStream(in.length)) {
            byte[] buf = new byte[1024];
            while(!decompressor.finished()) {
                int count = decompressor.inflate(buf);
                baos.write(buf, 0, count);
            }
            decompressedBytes = baos.toByteArray();
        } catch (IOException | DataFormatException ex) {
            ex.printStackTrace();
        }

        return decompressedBytes;
    }
}
