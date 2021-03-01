package uphf.kafka.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fisa.console.editor.Editor;


//point d'entrée de l'application

@SpringBootApplication
public class SpringBootWithKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithKafkaApplication.class, args);
	}
} 
