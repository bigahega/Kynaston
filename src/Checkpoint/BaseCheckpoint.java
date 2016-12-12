package Checkpoint;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Berkin GÜLER (bguler15@ku.edu.tr) on 14.11.2016.
 */
abstract class BaseCheckpoint implements ICheckpoint {

    byte[] hashmapToByteArray(ConcurrentHashMap<String, String> map) {
        byte[] out = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(map);
            out = byteArrayOutputStream.toByteArray();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return out;
    }

}
