package pr2_cs3.kafka;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TopicsConfiguration {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value = "${reception.topic.name}")
    private String receptionTopicName;

    @Value(value = "${envoi.topic.name}")
    private String envoiTopicName;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topicReception() {
        return TopicBuilder.name(receptionTopicName)
                .partitions(10)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic topicEnvoi() {
        return TopicBuilder.name(envoiTopicName)
                .partitions(10)
                .replicas(1)
                .build();
    }
}