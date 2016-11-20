package Checkpoint;

/**
 * Created by Berkin GÜLER (bguler15@ku.edu.tr) on 10.11.2016.
 */
public class CheckpointFactory {
    private static CheckpointFactory ourInstance = new CheckpointFactory();

    public static CheckpointFactory getInstance() {
        return ourInstance;
    }

    private CheckpointFactory() {
    }

    public Checkpoint getCheckpoint(CheckpointType checkpointType) {
        switch (checkpointType) {
            case Full:
                return new FullCheckpoint();
            case Incremental:
                return new IncrementalCheckpoint();
            case Differential:
                return new DifferentialCheckpoint();
            case Compressed:
                return new CompressedCheckpoint();
            default:
                return null;
        }
    }
}
