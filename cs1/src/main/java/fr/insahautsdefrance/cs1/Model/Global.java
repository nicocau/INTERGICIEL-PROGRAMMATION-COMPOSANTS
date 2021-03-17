package fr.insahautsdefrance.cs1.Model;

public class Global {
    private int NewConfirmed;
    private int TotalConfirmed;
    private int NewDeaths;
    private int TotalDeaths;
    private int NewRecovered;
    private int TotalRecovered;
    private String Date;

    public fr.insahautsdefrance.cs1.entity.Global convert() {
        fr.insahautsdefrance.cs1.entity.Global res = new fr.insahautsdefrance.cs1.entity.Global();

        res.setNewConfirmed(this.NewConfirmed);
        res.setTotalConfirmed(this.TotalConfirmed);
        res.setNewDeaths(this.NewDeaths);
        res.setTotalDeaths(this.TotalDeaths);
        res.setNewRecovered(this.NewRecovered);
        res.setTotalRecovered(this.TotalRecovered);
        res.setDatemaj(this.Date);

        return res;
    }
}
