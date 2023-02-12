package racingCar;

import racingCar.util.NumberGenerator;

public class FixedNumberGenerator implements NumberGenerator {

    private final int fixedNumber;

    public FixedNumberGenerator(int fixedNumber) {
        this.fixedNumber = fixedNumber;
    }

    @Override
    public int generateNumber() {
        return fixedNumber;
    }
}
