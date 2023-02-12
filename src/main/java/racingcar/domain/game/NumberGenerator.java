package racingcar.domain.game;

public class NumberGenerator {

    private static final int ONE = 1;

    private final Random random;

    public NumberGenerator(final Random random) {
        this.random = random;
    }

    public int generate(final int minNumber, final int maxNumber) {
        return (int) ((random.greaterOrEqualZeroAndLessThenOne() * (maxNumber - minNumber + ONE)) + minNumber);
    }
}
