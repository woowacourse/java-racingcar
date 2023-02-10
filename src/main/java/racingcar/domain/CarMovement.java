package racingcar.domain;

import static racingcar.config.CarMovementConfig.*;

public class CarMovement {
    private final NumberGenerator numberGenerator;

    public CarMovement(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean isCarMoveForward() {
        int number = numberGenerator.generateNumber();
        if (isStop(number)) {
            return false;
        }
        if (isForward(number)) {
            return true;
        }
        return false;
    }

    private boolean isForward(int number) {
        return (MOVE_FORWARD_MIN_NUMBER.getNumber() <= number && number <= MOVE_FORWARD_MAX_NUMBER.getNumber());
    }

    private boolean isStop(int number) {
        return (STOP_MIN_NUMBER.getNumber() <= number && number <= STOP_MAX_NUMBER.getNumber());
    }
}
