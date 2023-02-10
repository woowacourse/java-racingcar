package racingcar.service;

import java.util.Random;

public class RandomMaker {

    private static final int MAXIMUM_VALUE = 10;

    public static int random() {
        Random random = new Random();

        return random.nextInt(MAXIMUM_VALUE);
    }
}
