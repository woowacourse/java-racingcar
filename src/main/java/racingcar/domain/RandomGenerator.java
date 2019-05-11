package racingcar.domain;

public class RandomGenerator {
    private static final int RANDOM_NUM_SCOPE = 10;

    private RandomGenerator() {}

    public static int generateRandomNum() {
        return (int) (Math.random() * RANDOM_NUM_SCOPE);
    }
}
