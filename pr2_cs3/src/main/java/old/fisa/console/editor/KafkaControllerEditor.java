package old.fisa.console.editor;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;


import old.uphf.kafka.demo.engine.Consumer;
import old.uphf.kafka.demo.engine.Producer;

class KafkaControllerEditor {
	private final Producer producer;
    private final Consumer consumer;

    @Autowired
    KafkaControllerEditor(Producer producer, Consumer consumer) {
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
    public String sendMessageToKafkaTopic(String message) throws IOException {
        producer.sendMessagePr2(message);
        String re= consumer.consumeCs2(message);
        re =re + " message in topic 3: ";
        producer.sendMessagePr3(re);
        return consumer.consumeCs3(re);
    }
}
