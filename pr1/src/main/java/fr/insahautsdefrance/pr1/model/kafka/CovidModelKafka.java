package fr.insahautsdefrance.pr1.model.kafka;

import fr.insahautsdefrance.pr1.model.gson.CountriesGson;
import fr.insahautsdefrance.pr1.model.gson.CovidModelGson;

import java.util.ArrayList;

public class CovidModelKafka {
    private GlobalKafka global;

    private ArrayList<CountriesKafka> countries = new ArrayList<CountriesKafka>();

    public static CovidModelKafka convert(CovidModelGson covidModelGson) {
        CovidModelKafka covidModelKafka = new CovidModelKafka();
        covidModelKafka.global = GlobalKafka.convert(covidModelGson.getGlobal());
        for (CountriesGson countriesGson : covidModelGson.getCountries()) {
            covidModelKafka.countries.add(CountriesKafka.convert(countriesGson));
        }
        return covidModelKafka;
    }
}
