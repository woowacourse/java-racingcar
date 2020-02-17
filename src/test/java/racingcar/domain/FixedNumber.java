package racingcar.domain;

import racingcar.domain.Generator.RandomGenerator;

public class FixedNumber implements RandomGenerator {

    @Override
    public boolean isMovable() {
        return true;
    }
}
