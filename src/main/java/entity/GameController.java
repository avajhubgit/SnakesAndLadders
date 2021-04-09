package entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("game")
public class GameController {
    final static String URI_DICE = "http://localhost:8082/dices/";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    //use restTemplate here
    @GetMapping("/move")
    public Token move() {
        Dice dice = restTemplate.getForObject(URI_DICE, Dice.class);
        if (dice != null) {
            Token token = new Token();
            token.setSquare(dice.getValue());
            return token;
        }
        return null;
    }

    //use restTemplate here
    @GetMapping("/movereact")
    public Token moveReact() {
        Dice dice = webClientBuilder.build()
                .get()
                .uri(URI_DICE)
                .retrieve()
                .bodyToMono(Dice.class)
                .block();
        if (dice != null) {
            Token token = new Token();
            token.setSquare(dice.getValue());
            return token;
        }
        return null;
    }
}
