package racingcar.utils;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random RANDOM = new Random();
    private static final int START = 0;
    private static final int END = 10;

    public int getNumber() {
        return START + RANDOM.nextInt(END);
    }
}
