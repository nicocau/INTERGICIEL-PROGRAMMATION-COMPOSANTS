package fr.insahautsdefrance.pr1.model.kafka;

import fr.insahautsdefrance.pr1.model.gson.GlobalGson;

import java.sql.Date;

public class GlobalKafka {
    private int newConfirmed;

    private int totalConfirmed;

    private int newDeaths;

    private int totalDeaths;

    private int newRecovered;

    private int totalRecovered;

    private Date datemaj;

    public static GlobalKafka convert(GlobalGson globalGson) {
        GlobalKafka globalKafka = new GlobalKafka();

        globalKafka.newConfirmed = globalGson.getNewConfirmed();
        globalKafka.totalConfirmed = globalGson.getNewConfirmed();
        globalKafka.newDeaths = globalGson.getNewDeaths();
        globalKafka.totalDeaths = globalGson.getTotalDeaths();
        globalKafka.newRecovered = globalGson.getNewRecovered();
        globalKafka.totalRecovered = globalGson.getTotalRecovered();
        globalKafka.datemaj = Date.valueOf(globalGson.getDate());

        return globalKafka;
    }
}
