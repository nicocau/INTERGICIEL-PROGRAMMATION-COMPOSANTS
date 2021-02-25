package fr.insahautsdefrance.pr3_cs2;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class Pr3Cs2Application {
	public static void main(String[] args) {
		//SpringApplication.run(Pr3Cs2Application.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(Pr3Cs2Application.class, args);

		Producer producer = context.getBean(Producer.class);
		producer.send("Topic2","Hello, World!");
	}
}
