package fr.insahautsdefrance.pr3_cs2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Controller {
    @Value(value = "${reception.topic.name}")
    private String receptionTopicName;

    @Value(value = "${envoi.topic.name}")
    private String envoiTopicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "#{'${reception.topic.name}'}", groupId = "myGroup")
    private void listener(String data) {
        System.out.println(data);
        kafkaTemplate.send(envoiTopicName, data + "RESPONSE");
    }
}
