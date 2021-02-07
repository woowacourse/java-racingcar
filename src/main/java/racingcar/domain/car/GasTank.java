package racingcar.domain.car;

import racingcar.utils.RandomUtils;

public class GasTank {

    private static final int MINIMUM_GAS = 0;
    private static final int MAXIMUM_GAS = 9;
    private static final int ENOUGH_GAS = 4;

    GasTank() {
    }

    boolean isEnoughGas() {
        return RandomUtils.nextPositiveInt(MINIMUM_GAS, MAXIMUM_GAS) >= ENOUGH_GAS;
    }

}
