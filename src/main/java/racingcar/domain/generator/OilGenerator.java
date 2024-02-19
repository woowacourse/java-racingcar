package racingcar.domain.generator;

import racingcar.exception.OilOutOfRangeException;

public abstract class OilGenerator {

    public static final int MIN_OIL_AMOUNT = 0;
    public static final int MAX_OIL_AMOUNT = 9;

    public int generateValidOil() {
        int oil = generate();
        if (oil < MIN_OIL_AMOUNT || oil > MAX_OIL_AMOUNT) {
            throw new OilOutOfRangeException();
        }
        return oil;
    }

    protected abstract int generate();
}
