package racingcar.utils;

import java.util.Random;

public class RandomConstructor {
    private Random random = new Random();

    public int getRandomNumber() {
        return random.nextInt(10);
    }
}
