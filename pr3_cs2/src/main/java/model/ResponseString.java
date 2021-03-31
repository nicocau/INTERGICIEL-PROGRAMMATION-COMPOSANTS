package model;

public class ResponseString extends Response {
    private Request request;
    private String value;

    public ResponseString(){
        super();
    }

    public ResponseString(Request request, String value) {
        super();
        this.request = request;
        this.value = value;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ResponseString [request=" + request + ", value=" + value + "]";
    }
}
