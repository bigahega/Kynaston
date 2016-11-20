package Checkpoint.Compression;

import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.UnsupportedOptionsException;
import org.tukaani.xz.XZInputStream;
import org.tukaani.xz.XZOutputStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Berkin GÜLER (bguler15@ku.edu.tr) on 14.11.2016.
 */
public class LZMA2Compressor implements Compressor {
    @Override
    public byte[] compress(byte[] in) {
        byte[] compressedBytes = null;

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            XZOutputStream xzOutputStream = new XZOutputStream(baos, new LZMA2Options(LZMA2Options.PRESET_MAX));
            xzOutputStream.write(in);
            xzOutputStream.close();
            compressedBytes = baos.toByteArray();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return compressedBytes;
    }

    @Override
    public byte[] decompress(byte[] in) {
        byte[] decompressedBytes = null;

        try(XZInputStream xzInputStream = new XZInputStream(new ByteArrayInputStream(in));
            ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int read = 0;

            while((read = xzInputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, read);
            }

            decompressedBytes = baos.toByteArray();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return decompressedBytes;
    }
}
