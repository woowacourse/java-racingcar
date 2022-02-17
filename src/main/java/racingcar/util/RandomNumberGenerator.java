package racingcar.util;

public class RandomNumberGenerator {

    private static final int RANDOM_RANGE = 10;

    public int generateRandomNumber() {
        return (int) (Math.random() * RANDOM_RANGE);
    }
}
