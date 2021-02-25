package fr.insahautsdefrance.pr3_cs2;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Listeners {
    @KafkaListener(topics = "Topic1", groupId = "myGroup")
    @SendTo("Topic2")
    String listener(String data) {
        System.out.println(data);
        return data + " RESPONSE";
    }
}
