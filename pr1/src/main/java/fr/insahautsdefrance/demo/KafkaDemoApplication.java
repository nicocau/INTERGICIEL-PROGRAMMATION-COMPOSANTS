package fr.insahautsdefrance.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication

public class KafkaDemoApplication implements ApplicationRunner {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {kafkaTemplate.send("MonTopic", msg);}

    public static void main(String[] args) {SpringApplication.run(KafkaDemoApplication.class, args);}

    @KafkaListener(topics = "MonTopic", groupId = "group-id")
    public void listen(String message) {System.out.println("Reception d'un message sur le group-id: " + message);}

    @Override
    public void run(ApplicationArguments args) throws Exception {sendMessage("Salut les Master2 TNSI");}
}
