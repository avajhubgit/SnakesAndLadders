package entity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SnakesAndLaddersApplication {

    @Bean
    public RestTemplate initRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebClient.Builder initWebClientBuilder() {
        return WebClient.builder();
    }

    public static void main(String[] args) {
        SpringApplication.run(SnakesAndLaddersApplication.class, args);
    }

}
