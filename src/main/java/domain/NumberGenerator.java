package domain;

public class Racing {
    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;

    public static Integer generateRandomNumber() {
        return (int) (Math.random() * RANDOM_NUMBER_UPPER_BOUND);
    }
}
