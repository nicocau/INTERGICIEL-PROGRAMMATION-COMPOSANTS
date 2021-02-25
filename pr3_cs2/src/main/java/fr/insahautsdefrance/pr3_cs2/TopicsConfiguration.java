package fr.insahautsdefrance.pr3_cs2;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class TopicsConfiguration {

    /*
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;
    */

    @Value(value = "${reception.topic.name}")
    private String receptionTopicName;

    @Value(value = "${envoi.topic.name}")
    private String envoiTopicName;

    /*
    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }
    */

    /*
    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                bootstrapAddress);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        return props;
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
     */
    /*
    @Bean
    public NewTopic topicReception() {
        return new NewTopic(receptionTopicName, 1, (short) 1);
    }

    @Bean
    public NewTopic topicEnvoi() {
        return new NewTopic(envoiTopicName, 6, (short) 1);
    }
     */
    /*
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
    */
}