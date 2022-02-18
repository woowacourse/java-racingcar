package racingcar.utils;

import java.util.Random;

public class RandomNumberGenerator {

    public static int makeRandom(int randomNumberBound) {
        Random random = new Random();
        return random.nextInt(randomNumberBound);
    }
}
