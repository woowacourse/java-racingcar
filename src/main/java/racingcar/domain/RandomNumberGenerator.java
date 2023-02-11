package racingcar.domain;

import static racingcar.constant.GameConstant.MAXIMUM_POWER_OF_ENGINE;
import static racingcar.constant.GameConstant.MINIMUM_POWER_OF_ENGINE;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return (int) (Math.random() * (MAXIMUM_POWER_OF_ENGINE - MINIMUM_POWER_OF_ENGINE+1)) + MINIMUM_POWER_OF_ENGINE;
    }
}
