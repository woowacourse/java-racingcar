package racingcar.exception.car;

import racingcar.exception.RacingCarException;
import racingcar.exception.car.message.CarNameExceptionMessage;

public class CarNameDuplicatedException extends RacingCarException {

	public CarNameDuplicatedException() {
		super(CarNameExceptionMessage.NAME_DUPLICATED_EXCEPTION_MESSAGE);
	}

}
