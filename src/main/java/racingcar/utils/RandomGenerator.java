package racingcar.utils;


import java.util.Random;

public class RandomGenerator {

    private static final int RANDOM_ADJUSTMENT = 1;

    public static int getRandomNumberInRange(int end) {
        Random random = new Random();
        return random.nextInt(end + RANDOM_ADJUSTMENT);
    }
}
