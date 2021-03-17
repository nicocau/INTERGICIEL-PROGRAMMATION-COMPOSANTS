package fr.insahautsdefrance.cs1.Controller;

import com.google.gson.Gson;
import fr.insahautsdefrance.cs1.Model.Countries;
import fr.insahautsdefrance.cs1.Model.CovidModel;
import fr.insahautsdefrance.cs1.entity.Global;
import fr.insahautsdefrance.cs1.repository.CountriesRepository;
import fr.insahautsdefrance.cs1.repository.GlobalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class Controller {
    @Autowired
    CountriesRepository countriesRepository;

    @Autowired
    GlobalRepository globalRepository;

    @KafkaListener(topics = "#{'${topic1.topic.name}'}", groupId = "myGroup")
    private void listener(String data) throws ParseException {
        Gson g = new Gson();
        CovidModel covidModel = g.fromJson(data, CovidModel.class);
        this.countriesRepository.deleteAll();
        this.globalRepository.deleteAll();

        for (Countries countries : covidModel.getCountries()) {
            this.countriesRepository.saveAndFlush(countries.convert());
        }

        Global convert = covidModel.getGlobal().convert();
        this.globalRepository.save(convert);
        this.globalRepository.flush();

        System.out.println(data);
    }


}