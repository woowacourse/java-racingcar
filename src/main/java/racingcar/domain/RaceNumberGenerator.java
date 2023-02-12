package racingcar.domain;

import racingcar.util.NumberGenerator;

import java.util.concurrent.ThreadLocalRandom;

import static racingcar.domain.constant.RaceConstant.MAX_RACE_CONDITION;
import static racingcar.domain.constant.RaceConstant.MIN_RACE_CONDITION;

public class RaceNumberGenerator implements NumberGenerator {

    private final int minNumber = MIN_RACE_CONDITION.getValue();

    private final int maxNumber = MAX_RACE_CONDITION.getValue();

    @Override
    public int generate() {
        return minNumber + ThreadLocalRandom.current().nextInt(maxNumber - minNumber + 1);
    }
}
