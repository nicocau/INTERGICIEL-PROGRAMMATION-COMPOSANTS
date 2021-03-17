package fr.insahautsdefrance.pr1.model.kafka;

import fr.insahautsdefrance.pr1.model.gson.CountriesGson;

import java.sql.Date;

public class CountriesKafka {
    private String idContry;

    private String countryCode;

    private String country;

    private String slug;

    private int newConfirmed;

    private int totalConfirmed;

    private int newDeaths;

    private int totalDeaths;

    private int newRecovered;

    private int totalRecovered;

    private Date datemaj;

    public static CountriesKafka convert(CountriesGson countriesGson){
        CountriesKafka countriesKafka = new CountriesKafka();

        countriesKafka.idContry = countriesGson.getID();
        countriesKafka.countryCode = countriesGson.getCountryCode();
        countriesKafka.country = countriesGson.getCountry();
        countriesKafka.slug = countriesGson.getSlug();
        countriesKafka.newConfirmed = countriesGson.getNewConfirmed();
        countriesKafka.totalConfirmed = countriesGson.getTotalConfirmed();
        countriesKafka.newDeaths = countriesGson.getNewDeaths();
        countriesKafka.totalDeaths = countriesGson.getTotalDeaths();
        countriesKafka.newRecovered = countriesGson.getNewRecovered();
        countriesKafka.totalRecovered = countriesGson.getTotalRecovered();
        countriesKafka.datemaj = Date.valueOf(countriesGson.getDate());

        return countriesKafka;
    }
}
