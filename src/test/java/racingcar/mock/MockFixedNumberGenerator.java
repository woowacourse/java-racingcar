package racingcar.mock;

import racingcar.domain.game.NumberGenerator;

public class MockFixedNumberGenerator implements NumberGenerator {

    private final int returnNumber;

    public MockFixedNumberGenerator(final int returnNumber) {
        this.returnNumber = returnNumber;
    }

    @Override
    public int generate(final int minNumber, final int maxNumber) {
        return returnNumber;
    }
}
