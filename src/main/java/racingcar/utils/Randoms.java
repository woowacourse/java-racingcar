package racingcar.utils;


import java.util.concurrent.ThreadLocalRandom;

public class Randoms {

    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;
    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    private Randoms() {
        throw new UnsupportedOperationException();
    }


    public static int getRandInt() {
        return random.nextInt(RANDOM_NUMBER_UPPER_BOUND);
    }
}
