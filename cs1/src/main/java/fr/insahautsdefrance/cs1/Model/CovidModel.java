package fr.insahautsdefrance.cs1.Model;

import java.util.ArrayList;

public class CovidModel {
    private String ID;
    private String Message;
    private Global Global;
    private ArrayList<Countries> Countries;
    private String Date;

    public Global getGlobal() {
        return Global;
    }

    public ArrayList<Countries> getCountries() {
        return Countries;
    }
}
