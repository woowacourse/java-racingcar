package racingcar.model;

public class Random {
    private final static int MAX_RANDOM_NUMBER = 10;
    private final static int MIN_RANDOM_NUMBER = 0;

    public static int createRandomNumber() {
        return ((int) (Math.random() * MAX_RANDOM_NUMBER) + MIN_RANDOM_NUMBER);
    }
}
