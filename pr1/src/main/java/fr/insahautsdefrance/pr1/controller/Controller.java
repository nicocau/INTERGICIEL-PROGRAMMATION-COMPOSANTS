package fr.insahautsdefrance.pr1.controller;

import com.google.gson.Gson;
import fr.insahautsdefrance.pr1.http.Covid19API;
import fr.insahautsdefrance.pr1.kafka.ProducerConfiguration;
import fr.insahautsdefrance.pr1.kafka.TopicsConfiguration;
import fr.insahautsdefrance.pr1.model.gson.CovidModelGson;
import fr.insahautsdefrance.pr1.model.kafka.CovidModelKafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Controller {
    @Autowired
    private Covid19API covid19API;

    @Autowired
    private ProducerConfiguration producerConfiguration;

    @Autowired
    private TopicsConfiguration topicsConfiguration;

    @Scheduled(fixedDelay = 10000)
    private void run() {
        String data = this.covid19API.getInformation();


        Gson g = new Gson();
        CovidModelGson covidModel = g.fromJson(data, CovidModelGson.class);

        CovidModelKafka covidModelKafka = CovidModelKafka.convert(covidModel);


        this.producerConfiguration.kafkaTemplate().send(this.topicsConfiguration.topicEnvoi().name(), data);
    }
}
