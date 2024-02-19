package racingcar.domain;

import java.util.Random;

public class RandomNumberImpl implements RandomNumber{
    private static final int MAX_NUMBER = 10;

    public int generate() {
        Random random = new Random();
        return random.nextInt(MAX_NUMBER);
    }
}
