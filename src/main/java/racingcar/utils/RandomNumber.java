package racingcar.utils;

import java.util.Random;

public class RandomNumber {
    private static final int maxRange = 10;

    private RandomNumber() {
    }

    public static int generateRandomIntIntRange() {
        Random r = new Random();
        return r.nextInt(maxRange);
    }
}
