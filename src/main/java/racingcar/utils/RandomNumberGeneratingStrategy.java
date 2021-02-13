package racingcar.utils;

import static racingcar.domain.RacingGameRule.DRIVE_MAXIMUM_VALUE;
import static racingcar.domain.RacingGameRule.DRIVE_MINIMUM_VALUE;

public class RandomNumberGeneratingStrategy implements NumberGeneratingStrategy {

    @Override
    public int generateNumber() {
        return RandomUtils.nextInt(DRIVE_MINIMUM_VALUE, DRIVE_MAXIMUM_VALUE);
    }
}
