package racingcar.exception.car;

import racingcar.exception.RacingCarException;
import racingcar.exception.car.message.CarNameExceptionMessage;

public class CarNameTooLongException extends RacingCarException {

	public CarNameTooLongException() {
		super(CarNameExceptionMessage.NAME_TOO_LONG_EXCEPTION_MESSAGE);
	}

}
