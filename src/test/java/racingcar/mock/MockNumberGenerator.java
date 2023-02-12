package racingcar.mock;

import racingcar.util.NumberGenerator;

public class MockNumberGenerator implements NumberGenerator {

    private int randomNumber = 0;

    private final boolean isIncrease;

    public MockNumberGenerator(final boolean isIncrease) {
        this.isIncrease = isIncrease;
    }

    @Override
    public int generate() {
        if (isIncrease) {
            return randomNumber = randomNumber * 2 + 1;
        }
        return randomNumber;
    }
}
