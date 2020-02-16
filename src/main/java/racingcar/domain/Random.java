package racingcar.domain;

public class Random {
    public static final int RANDOM_VALUE_LIMIT = 10;

    private Random() { }

    public static int createRandomValue() {
        return (int) (Math.random() * RANDOM_VALUE_LIMIT);
    }

}
