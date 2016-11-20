package Service.TxObjects;

import java.io.Serializable;

/**
 * Created by berkinguler on 20/11/2016.
 */
public class Request implements Serializable {

    private final RequestType requestType;
    private final String key;
    private final String value;

    public Request(RequestType requestType, String key, String value) {
        this.requestType = requestType;
        this.key = key;
        this.value = value;
    }

    public Request(RequestType requestType, String key) {
        this(requestType, key, null);
    }

    public Request(RequestType requestType) {
        this(requestType, null, null);
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
