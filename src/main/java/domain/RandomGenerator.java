package domain;

public class RandomGenerator {

    private static final int CAR_MOVE_RANGE = 10;

    private RandomGenerator() {
    }

    public static int getRandomNumber() {
        return (int) (Math.random() * CAR_MOVE_RANGE);
    }
}
