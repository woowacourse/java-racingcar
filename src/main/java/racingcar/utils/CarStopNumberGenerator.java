package racingcar.utils;

import racingcar.domain.NumberGenerator;

import static racingcar.config.CarMovementConfig.STOP_MAX_NUMBER;

public class CarStopNumberGenerator implements NumberGenerator {
    public int generateNumber() {
        return STOP_MAX_NUMBER.getNumber();
    }
}
