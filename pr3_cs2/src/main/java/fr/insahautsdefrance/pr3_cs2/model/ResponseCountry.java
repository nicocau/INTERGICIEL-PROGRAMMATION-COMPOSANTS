package fr.insahautsdefrance.pr3_cs2.model;

import fr.insahautsdefrance.pr3_cs2.entity.Country;

public class ResponseCountry extends Response {
    private Request request;
    private Country value;

    public ResponseCountry(){
        super();
    }

    public ResponseCountry(Request request, Country value) {
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

    public Country getValue() {
        return value;
    }

    public void setValue(Country value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ResponseCountry [request=" + request + ", value=" + value + "]";

    }
}
