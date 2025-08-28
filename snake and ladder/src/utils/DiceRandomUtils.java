package utils;

import java.util.Random;

public class DiceRandomUtils {
    Random random = new Random();
    int min = 1, max = 6;
    public int generateDiceNumber() {
        int randomNumber = random.nextInt((max - min) + 1) + min;
        return randomNumber;
    }
}
