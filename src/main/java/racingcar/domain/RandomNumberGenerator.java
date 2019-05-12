package racingcar.domain;

import java.util.Random;

public class RandomNumberGenerator {
    public static int generateRandomNumber(int bound, int lowerBound) {
        Random random = new Random();
        return random.nextInt(bound) + lowerBound;
    }
}
