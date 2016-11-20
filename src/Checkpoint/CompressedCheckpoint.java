package Checkpoint;

import Checkpoint.Compression.CompressionType;
import Checkpoint.Compression.Compressor;
import Checkpoint.Compression.CompressorFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Berkin GÜLER (bguler15@ku.edu.tr) on 14.11.2016.
 */
public class CompressedCheckpoint extends BaseCheckpoint implements Checkpoint {
    private CheckpointType checkpointType;
    private CompressionType compressionType;

    public void setCheckpointType(CheckpointType checkpointType) {
        this.checkpointType = checkpointType;
    }

    public void setCompressionType(CompressionType compressionType) {
        this.compressionType = compressionType;
    }

    @Override
    public byte[] createCheckpoint(ConcurrentHashMap<String, String> database) {
        Checkpoint checkpointer;
        switch (this.checkpointType) {
            case Full:
                checkpointer = new FullCheckpoint();
                break;
            case Incremental:
                checkpointer = new IncrementalCheckpoint();
                break;
            case Differential:
                checkpointer = new DifferentialCheckpoint();
                break;
            default:
                checkpointer = null;
                break;
        }

        if(checkpointer == null)
            return null;

        byte[] uncompressedCheckpoint = checkpointer.createCheckpoint(database);
        Compressor compressor = CompressorFactory.getInstance().getCompressor(this.compressionType);
        byte[] compressedCheckpoint = compressor.compress(uncompressedCheckpoint);

        return compressedCheckpoint;
    }
}
