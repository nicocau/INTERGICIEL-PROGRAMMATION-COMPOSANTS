package pr2_cs3;

import model.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import model.Request;

import java.util.Arrays;
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
        String input = "";

        while(!input.equals("Exit")){
            if(!input.isEmpty()){
                Request request = new Request();
                request.setCommand(input);

                if(input.contains("Get_country_values")){
                    request.setCommand("Get_country_values");
                    Arrays.stream(input.split(" "))
                            .filter( s -> !s.equals("Get_country_values"))
                            .forEach(s -> request.getParams().add(new Params("v_pays", s)));
                }

                System.out.println(request);
                kafkaTemplate.send(envoiTopicName, request);
            }

            input = scanner.nextLine();
            System.out.println("> " + input);
        }
    }
}
