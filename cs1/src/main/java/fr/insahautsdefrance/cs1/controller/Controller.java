package fr.insahautsdefrance.cs1.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Controller {
    @KafkaListener(topics = "#{'${topic1.topic.name}'}", groupId = "myGroup")
    private void listener(String data) {
        System.out.println(data);
    }


}