package racingcar.model;

import java.util.Random;

public class RandomNumber {

    private static final int MAX_BOUND = 10;

    public static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

}
