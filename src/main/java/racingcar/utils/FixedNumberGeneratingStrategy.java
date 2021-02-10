package racingcar.utils;

import racingcar.domain.RacingGameRule;

public class FixedNumberGeneratingStrategy implements NumberGeneratingStrategy {

    public static NumberGeneratingStrategy getInstance() {
        return new FixedNumberGeneratingStrategy();
    }

    @Override
    public int generateNumber() {
        return RacingGameRule.DRIVE_MAXIMUM_VALUE;
    }
}
