package racingcar.exception.car;

import static racingcar.exception.car.status.CarNameExceptionStatus.NAME_IS_TOO_LONG_EXCEPTION_STATUS;

import racingcar.exception.RacingCarIllegalArgumentException;

public class CarNameTooLongException extends RacingCarIllegalArgumentException {

    public CarNameTooLongException() {
        super(NAME_IS_TOO_LONG_EXCEPTION_STATUS.getMessage());
    }

}
