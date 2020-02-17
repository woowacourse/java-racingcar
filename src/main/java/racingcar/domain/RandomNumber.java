package racingcar.domain;

import java.util.Random;

class RandomNumber {
    private static final int RANDOM_MAX = 10;
    private static final int RANDOM_MIN = 0;

    private static Random random = new Random();

    public static int getRandomNumber() {
        return random.nextInt(RANDOM_MAX - RANDOM_MIN) + RANDOM_MIN;
    }
}
