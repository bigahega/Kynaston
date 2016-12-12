package Checkpoint.Compression;

/**
 * Created by Berkin GÜLER (bguler15@ku.edu.tr) on 14.11.2016.
 */
public class CompressorFactory {
    private static CompressorFactory ourInstance = new CompressorFactory();

    public static CompressorFactory getInstance() {
        return ourInstance;
    }

    private CompressorFactory() {
    }

    public Compressor getCompressor(CompressionType compressionType) {
        if(compressionType == null)
            compressionType = CompressionType.Deflate;
        switch (compressionType) {
            case Deflate:
                return new DeflateCompressor();
            case LZMA2:
                return new LZMA2Compressor();
            case ZStd:
                return new ZStdCompressor();
            default:
                return new DeflateCompressor();
        }
    }
}
