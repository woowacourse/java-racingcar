package racingcar.exception.car;

import static racingcar.exception.car.status.CarNameExceptionStatus.NAME_IS_DUPLICATED_EXCEPTION_STATUS;

import racingcar.exception.RacingCarIllegalArgumentException;

public class CarNameDuplicatedException extends RacingCarIllegalArgumentException {

    public CarNameDuplicatedException() {
        super(NAME_IS_DUPLICATED_EXCEPTION_STATUS.getMessage());
    }

}
