package Database;

/**
 * Created by Berkin GÜLER (bguler15@ku.edu.tr) on 10.11.2016.
 */
public interface IKynaston {

    String query(String  key);
    String update(String key, String value);
    byte[] checkpoint();

}
