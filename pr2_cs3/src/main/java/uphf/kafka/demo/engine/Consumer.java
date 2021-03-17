package uphf.kafka.demo.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
//import org.json;
@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    @KafkaListener(topics = "Topic3", groupId = "group_id")
    public String consumeCs3(String message) throws IOException {
    	
        logger.info(String.format("#### -> Consumed message -> %s", message));
        //JSONObject jo =new JSONObject();
        return "Reponse de notre consumer: "+message; 
    }
    
    @KafkaListener(topics = "Topic2", groupId = "group_id")
    public String consumeCs2(String message) throws IOException {
    	
        logger.info(String.format("#### -> Consumed message -> %s", message));
        return "Reponse de notre consumer: "+message;
    }
}
