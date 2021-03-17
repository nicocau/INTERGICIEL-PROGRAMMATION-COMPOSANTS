package uphf.kafka.demo.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC2 = "topic2";
    private static final String TOPIC3 = "topic3";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessagePr3(String message) { 
        logger.info(String.format("#### -> Producing message -> %s", message));
        this.kafkaTemplate.send(TOPIC3, message);
    }
    
    public void sendMessagePr2(String message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
        this.kafkaTemplate.send(TOPIC2, message);
    }
}
