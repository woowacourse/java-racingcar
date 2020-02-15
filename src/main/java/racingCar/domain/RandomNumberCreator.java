package racingCar.domain;

import java.util.Random;

public class RandomNumberCreator {
    private static Random randomNumberGenerator = new Random();
    public static int create() {

        return randomNumberGenerator.ints(0, 10)
                .limit(1).findFirst().orElse(-1);
    }
}
