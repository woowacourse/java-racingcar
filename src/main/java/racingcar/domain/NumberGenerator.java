package racingcar.domain;

public class NumberGenerator {

    private static final int ONE = 1;

    public int generate(final int minNumber, final int maxNumber) {
        return (int) ((Math.random() * (maxNumber - minNumber + ONE)) + minNumber);
    }
}
