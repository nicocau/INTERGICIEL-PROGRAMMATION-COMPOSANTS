package pr2_cs3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pr2_cs3.model.Request;

import java.util.Scanner;

@Component
public class Controller implements CommandLineRunner {
    @Value(value = "${reception.topic.name}")
    private String receptionTopicName;

    @Value(value = "${envoi.topic.name}")
    private String envoiTopicName;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(topics = "#{'${reception.topic.name}'}", groupId = "myGroup")
    private void listener(String data) {
        System.out.println(data);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(!input.equals("Exit")){
            Request request = new Request();
            request.setCommand(input);

            //TODO : Gestion des params

            kafkaTemplate.send(envoiTopicName, request);

            input = scanner.nextLine();
        }
    }
}
