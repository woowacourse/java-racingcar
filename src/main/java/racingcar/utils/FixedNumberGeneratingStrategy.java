package racingcar.utils;

import racingcar.domain.RacingGameRule;

public class FixedNumberGeneratingStrategy implements NumberGeneratingStrategy {

    @Override
    public int generateNumber() {
        return RacingGameRule.DRIVE_MAXIMUM_VALUE;
    }
}
