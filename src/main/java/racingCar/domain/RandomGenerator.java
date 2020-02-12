package racingCar.domain;

public class RandomGenerator {
    private static final int BOUND = 4;
    private static final int TEN = 10;

    private RandomGenerator() {
    }

    public static boolean decideGoOrStop() {
        int randomNumber = (int) (Math.random() * TEN);
        return randomNumber >= BOUND;
    }
}
