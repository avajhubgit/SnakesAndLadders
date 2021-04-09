package entity;

import java.util.Random;

public class DiceManager {
    Random random = new Random();
    final int MAX_DICE_VALUE = 6;

    public int nextDice() {
        return 1 + random.nextInt(MAX_DICE_VALUE);
    }
}
