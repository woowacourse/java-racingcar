package racingcar.domain;

public class RandomNumberGenerator {

    private static final int ONE = 1;

    public static int generateNumber(final int minNumber, final int maxNumber) {
        return (int) ((Math.random() * (maxNumber - minNumber + ONE)) + minNumber);
    }
}
