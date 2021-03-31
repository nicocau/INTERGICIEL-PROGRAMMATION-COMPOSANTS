package fr.insahautsdefrance.pr1.http;

import fr.insahautsdefrance.pr1.kafka.ProducerConfiguration;
import fr.insahautsdefrance.pr1.kafka.TopicsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Component
public class Covid19API {
    @Value(value = "${url.api.covid19}")
    private String urlApiCovid19;

    @Autowired
    private ProducerConfiguration producerConfiguration;

    @Autowired
    private TopicsConfiguration topicsConfiguration;

    @Scheduled(fixedDelay = 120000)
    public void getInformation() throws IOException, InterruptedException {
        try {
            HttpClient httpClient = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.NORMAL)
                    .connectTimeout(Duration.ofSeconds(20))
                    .build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlApiCovid19))
                    .GET()
                    .header("Accept", "application/json")
                    .build();
            HttpResponse response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            this.producerConfiguration.kafkaTemplate().send(this.topicsConfiguration.topicEnvoi().name(), (String) response.body());
            System.out.println((String) response.body());

        }catch (Exception e){
            System.out.println("Erreur communication http : "+e.getMessage());
            e.printStackTrace();
        }
    }
}
