package fr.insahautsdefrance.pr1.model.gson;

import java.util.ArrayList;

public class CovidModelGson {
    private String ID;

    private String Message;

    private GlobalGson Global;

    private ArrayList<CountriesGson> Countries;

    private String Date;

    public String getID() {
        return ID;
    }

    public String getMessage() {
        return Message;
    }

    public GlobalGson getGlobal() {
        return Global;
    }

    public ArrayList<CountriesGson> getCountries() {
        return Countries;
    }

    public String getDate() {
        return Date;
    }
}
