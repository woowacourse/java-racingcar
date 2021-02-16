package racingcar.utils;

import static racingcar.domain.Car.DRIVE_MAXIMUM_VALUE;

public class FixedNumberGeneratingStrategy implements NumberGeneratingStrategy {

    @Override
    public int generateNumber() {
        return DRIVE_MAXIMUM_VALUE;
    }
}
