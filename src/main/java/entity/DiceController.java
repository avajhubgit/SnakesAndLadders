package entity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiceController {
    private DiceManager diceManager;

    public DiceController() {
        diceManager = new DiceManager();
    }

    @GetMapping("/dices")
    public Dice getDepartment() {
        Dice dice = new Dice(diceManager.nextDice());
        return dice;
    }

}

