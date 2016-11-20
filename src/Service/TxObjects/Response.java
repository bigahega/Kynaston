package Service.TxObjects;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by berkinguler on 20/11/2016.
 */
public class Response implements Serializable {

    private final ResponseType responseType;
    private final Map<String, String> result;

    public Response(ResponseType responseType) {
        this(responseType, null);
    }

    public Response(ResponseType responseType, Map<String, String> result) {
        this.responseType = responseType;
        this.result = result;
    }

}
