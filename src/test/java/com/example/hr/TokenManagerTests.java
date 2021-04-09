package com.example.hr;

import entity.DiceManager;
import entity.TokenManager;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class TokenManagerTests {
    private TokenManager tokenManager;
    private DiceManager diceManager;

    @Before
    public void setup() {
        tokenManager = new TokenManager();
        diceManager = new DiceManager();
    }

    @Test
    public void checkInitToken() {
        assertNotNull(tokenManager);
        assertEquals(tokenManager.getSquare(), 1);
    }

    @Test
    public void checkIsWinner() {
        //set square to 97
        for (int i = 0; i < 40; i++) {
            tokenManager.move(i % 6);
        }
        tokenManager.move(3);
        assertEquals(tokenManager.getSquare(), 100);
        assertTrue(tokenManager.isWinner());
    }

    @Test
    public void checkIsNotWinner() {
        //set square to 97
        for (int i = 0; i < 40; i++) {
            tokenManager.move(i % 6);
        }
        tokenManager.move(6);
        assertEquals(tokenManager.getSquare(), 97);
        assertFalse(tokenManager.isWinner());
    }

    @Test
    public void moveToken() {
        int number = diceManager.nextDice();
        tokenManager.move(number);
        assertNotNull(tokenManager);
        assertEquals(tokenManager.getSquare(), number + 1);
    }

    @Test
    public void play() {
        int number = diceManager.nextDice();
        tokenManager.move(number);
        assertNotNull(tokenManager);
        assertEquals(tokenManager.getSquare(), number + 1);
    }
}
