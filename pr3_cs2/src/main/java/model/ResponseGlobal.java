package model;

import fr.insahautsdefrance.pr3_cs2.entity.Global;

public class ResponseGlobal extends Response {
    private Request request;
    private Global value;

    public ResponseGlobal() {
        super();
    }

    public ResponseGlobal(Request request, Global value) {
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

    public Global getValue() {
        return value;
    }

    public void setValue(Global value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ResponseGlobal [request=" + request + ", value=" + value + "]";
    }
}
