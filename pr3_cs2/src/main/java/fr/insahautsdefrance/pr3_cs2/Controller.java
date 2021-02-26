package fr.insahautsdefrance.pr3_cs2;

import fr.insahautsdefrance.pr3_cs2.model.Params;
import fr.insahautsdefrance.pr3_cs2.model.Request;
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
    private KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(topics = "#{'${reception.topic.name}'}", groupId = "myGroup")
    private void listener(Request data) {
        System.out.println(data);
        Params params = new Params("TES", "TOTO");
        kafkaTemplate.send(envoiTopicName, params);
    }

}
