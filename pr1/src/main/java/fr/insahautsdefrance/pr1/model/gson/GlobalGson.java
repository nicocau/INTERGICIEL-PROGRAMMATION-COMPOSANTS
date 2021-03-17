package fr.insahautsdefrance.pr1.model.gson;

public class GlobalGson {
    private int NewConfirmed;

    private int TotalConfirmed;

    private int NewDeaths;

    private int TotalDeaths;

    private int NewRecovered;

    private int TotalRecovered;

    private String Date;

    public int getNewConfirmed() {
        return NewConfirmed;
    }

    public int getTotalConfirmed() {
        return TotalConfirmed;
    }

    public int getNewDeaths() {
        return NewDeaths;
    }

    public int getTotalDeaths() {
        return TotalDeaths;
    }

    public int getNewRecovered() {
        return NewRecovered;
    }

    public int getTotalRecovered() {
        return TotalRecovered;
    }

    public String getDate() {
        return Date;
    }
}
