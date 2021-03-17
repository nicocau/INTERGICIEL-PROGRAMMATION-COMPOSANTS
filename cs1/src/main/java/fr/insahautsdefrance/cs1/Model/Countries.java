package fr.insahautsdefrance.cs1.Model;

import fr.insahautsdefrance.cs1.entity.Country;

public class Countries {
    private String ID;
    private String Country;
    private String CountryCode;
    private String Slug;
    private int NewConfirmed;
    private int TotalConfirmed;
    private int NewDeaths;
    private int TotalDeaths;
    private int NewRecovered;
    private int TotalRecovered;
    private String Date;

    public fr.insahautsdefrance.cs1.entity.Country convert() {
        fr.insahautsdefrance.cs1.entity.Country res = new Country();

        res.setCountry(this.Country);
        res.setCountryCode(this.CountryCode);
        res.setSlug(this.Slug);
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
