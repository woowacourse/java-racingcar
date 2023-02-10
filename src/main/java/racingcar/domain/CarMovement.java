package racingcar.domain;

import static racingcar.config.CarMovementConfig.*;
import static racingcar.messsages.ExceptionMessage.*;

public class CarMovement {
	private final NumberGenerator numberGenerator;

	public CarMovement(NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
	}

	public boolean isMove() {
		int number = numberGenerator.generateNumber();
		if (isStop(number)) {
			return false;
		}
		if (isForward(number)) {
			return true;
		}
		throw new IllegalStateException(CAR_MOVEMENT_NUMBER_EXCEPTION.getMessage());
	}

	private boolean isForward(int number) {
		return (MOVE_FORWARD_MIN_NUMBER.getNumber() <= number && number <= MOVE_FORWARD_MAX_NUMBER.getNumber());
	}

	private boolean isStop(int number) {
		return (STOP_MIN_NUMBER.getNumber() <= number && number <= STOP_MAX_NUMBER.getNumber());
	}
}
