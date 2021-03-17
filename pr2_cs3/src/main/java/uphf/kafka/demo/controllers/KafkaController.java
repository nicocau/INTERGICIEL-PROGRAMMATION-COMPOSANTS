package uphf.kafka.demo.controllers;

import uphf.kafka.demo.engine.Producer;
import uphf.kafka.demo.engine.Consumer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//declarer un controler REST API
//mappé sur localhost:9000/kafka

@RestController
@RequestMapping(value = "/uphf")
public class KafkaController {

    private final Producer producer;
    private final Consumer consumer;

    @Autowired
    KafkaController(Producer producer, Consumer consumer) {
    	this.producer = producer; 
    	this.consumer = consumer;
    	}

    /**********************************************************
    http://localhost:9000/kafka/publish?message=Hello the world
     * @param message
     * @return 
     * @throws IOException 
    ***********************************************************/
    
    //declare un service post pour le producer de nom publish.
    @GetMapping(value = "/publish")
    public String sendMessageToKafkaTopic(@RequestParam("message") String message) throws IOException {
        producer.sendMessagePr2(message);
        String re= consumer.consumeCs2(message);
        re =re + " message in topic 3: ";
        producer.sendMessagePr3(re);
        return consumer.consumeCs3(re);
    }
}