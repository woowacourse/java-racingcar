package racingcar.exception.car;

import static racingcar.exception.car.status.CarNameExceptionStatus.NAME_IS_EMPTY_EXCEPTION_STATUS;

import racingcar.exception.RacingCarIllegalArgumentException;

public class CarNameEmptyException extends RacingCarIllegalArgumentException {

    public CarNameEmptyException() {
        super(NAME_IS_EMPTY_EXCEPTION_STATUS.getMessage());
    }

}
