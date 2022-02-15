package racingcar.exception.car;

import racingcar.exception.RacingCarException;
import racingcar.exception.car.message.CarNameExceptionMessage;

public class CarNameNullException extends RacingCarException {

    public CarNameNullException() {
        super(CarNameExceptionMessage.NAME_IS_NULL.getMessage());
    }

}
