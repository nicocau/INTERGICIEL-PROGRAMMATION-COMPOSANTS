package fr.insahautsdefrance.cs1.Controller;

import com.google.gson.Gson;
import fr.insahautsdefrance.cs1.Model.CovidModel;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Controller {
    @KafkaListener(topics = "#{'${topic1.topic.name}'}", groupId = "myGroup")
    private void listener(String data) {
        Gson g = new Gson();
        CovidModel covidModel = g.fromJson(data, CovidModel.class);
        System.out.println(data);
    }


}