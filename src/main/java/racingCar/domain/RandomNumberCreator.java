package racingCar.domain;

import java.util.Random;

public class RandomNumberCreator {
    public static int create() {
        Random randomNumberGenerator = new Random();

        return randomNumberGenerator.ints(0, 10)
                .limit(1).findFirst().orElse(-1);
    }
}
