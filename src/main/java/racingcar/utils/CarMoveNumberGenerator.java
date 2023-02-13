package racingcar.utils;

import racingcar.domain.NumberGenerator;

import static racingcar.config.CarMovementConfig.MOVE_FORWARD_MIN_NUMBER;

public class CarMoveNumberGenerator implements NumberGenerator {
    public int generateNumber() {
        return MOVE_FORWARD_MIN_NUMBER.getNumber();
    }
}
