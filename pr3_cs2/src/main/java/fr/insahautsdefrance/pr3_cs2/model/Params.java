package fr.insahautsdefrance.pr3_cs2.model;

public class Params {
    private String name;
    private String value;

    public Params(){
        super();
    }

    public Params(String name, String value){
        super();
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Params [name=" + name + ", value=" + value + "]";
    }
}
