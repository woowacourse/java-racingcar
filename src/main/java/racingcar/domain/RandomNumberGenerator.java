package racingcar.domain;

import static racingcar.constant.GameConstant.MAXIMUM_NUMBER_OF_ENGINE;
import static racingcar.constant.GameConstant.MINIMUM_NUMBER_OF_ENGINE;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        return (int) (Math.random() * (MAXIMUM_NUMBER_OF_ENGINE - MINIMUM_NUMBER_OF_ENGINE + 1))
                + MINIMUM_NUMBER_OF_ENGINE;
    }
}
