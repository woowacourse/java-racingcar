package racingcar.exception.car;

import static racingcar.exception.car.status.CarNameExceptionStatus.NAME_IS_NULL_EXCEPTION_STATUS;

import racingcar.exception.RacingCarNullPointerException;

public class CarNameNullException extends RacingCarNullPointerException {

    public CarNameNullException() {
        super(NAME_IS_NULL_EXCEPTION_STATUS.getMessage());
    }

}
