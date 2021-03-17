package fr.insahautsdefrance.pr3_cs2;

import fr.insahautsdefrance.pr3_cs2.entity.Country;
import fr.insahautsdefrance.pr3_cs2.entity.Global;
import fr.insahautsdefrance.pr3_cs2.model.*;
import fr.insahautsdefrance.pr3_cs2.repository.CountryRepository;
import fr.insahautsdefrance.pr3_cs2.repository.GlobalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Controller {
    @Value(value = "${reception.topic.name}")
    private String receptionTopicName;

    @Value(value = "${envoi.topic.name}")
    private String envoiTopicName;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private GlobalRepository globalRepository;

    @KafkaListener(topics = "#{'${reception.topic.name}'}", groupId = "myGroup")
    private void listener(Request data) {
        Response response = getResponse(data);
        kafkaTemplate.send(envoiTopicName, response);
    }

    private Response getResponse(Request data) {
        switch (data.getCommand()) {
            case "Get_global_values":
                return this.getGlobalValues(data);
            case "Get_country_values":
                return this.getCountryValues(data);
            case "Get_confirmed_avg":
                return this.getConfirmedAvg(data);
            case "Get_deaths_avg":
                return this.getDeathsAvg(data);
            case "Get_countries_deaths_percent":
                return this.getCountriesDeathsPercent(data);
            case "Help":
                return this.getHelp(data);
            default:
                return new ResponseString(data, "Undefined command");
        }
    }

    private Response getGlobalValues(Request data) {
        Optional<Global> global = globalRepository.findFirstByOrderByIdAsc();
        if (global.isPresent()) {
            return new ResponseGlobal(data, global.get());
        }
        return new ResponseString(data, "No data available");
    }

    private Response getCountryValues(Request data) {
        Optional<Params> pays = data.getParams().stream().filter(param -> param.getName().equals("v_pays")).findFirst();
        if (pays.isPresent()) {
            List<Country> countries = countryRepository.findByCountry(pays.get().getValue());
            if (!countries.isEmpty()) {
                return new ResponseCountry(data, countries.get(0));
            }
            return new ResponseString(data, "No data available");
        }
        return new ResponseString(data, "Bad param: v_pays");
    }

    private Response getConfirmedAvg(Request data) {
        List<Country> countries = countryRepository.findAll();
        if (!countries.isEmpty()) {
            int avg = 0;
            for (Country country : countries) {
                avg += country.getTotalConfirmed();
            }
            avg = avg / countries.size();
            return new ResponseString(data, String.valueOf(avg));
        }
        return new ResponseString(data, "No data available");
    }

    private Response getDeathsAvg(Request data) {
        List<Country> countries = countryRepository.findAll();
        if (!countries.isEmpty()) {
            int avg = 0;
            for (Country country : countries) {
                avg += country.getTotalDeaths();
            }
            avg = avg / countries.size();
            return new ResponseString(data, String.valueOf(avg));
        }
        return new ResponseString(data, "No data available");
    }

    private Response getCountriesDeathsPercent(Request data) {
        List<Country> countries = countryRepository.findAll();
        if (!countries.isEmpty()) {
            int deaths = 0;
            int confirmed = 0;
            for (Country country : countries) {
                deaths += country.getTotalDeaths();
                confirmed += country.getTotalConfirmed();
            }
            int percentage = deaths / confirmed;
            return new ResponseString(data, String.valueOf(percentage));
        }
        return new ResponseString(data, "No data available");
    }

    private Response getHelp(Request data) {
        return new ResponseString(data,
                "Get_global_values (retourne les valeurs globales clés Global du fichier json)\n" +
                        "Get_country_values v_pays (retourne les valeurs du pays demandé ou v_pays est une chaine de caractère du pays demandé)\n" +
                        "Get_confirmed_avg (retourne une moyenne des cas confirmés sum(pays)/nb(pays))\n" +
                        "Get_deaths_avg (retourne une moyenne des Décès sum(pays)/nb(pays))\n" +
                        "Get_countries_deaths_percent (retourne le pourcentage de Décès par rapport aux cas confirmés)\n" +
                        "Help (affiche la liste des commandes)");
    }

}
