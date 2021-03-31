package model;

import java.util.List;

public class Request {
    private String command;
    private List<Params> params;

    public Request(){
        super();
    }

    public Request(String command, List<Params> params) {
        super();
        this.command = command;
        this.params = params;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public List<Params> getParams() {
        return params;
    }

    public void setParams(List<Params> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "Request [command=" + command + ", params=" + params + "]";
    }
}
