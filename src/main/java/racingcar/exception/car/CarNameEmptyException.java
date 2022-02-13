package racingcar.exception.car;

import racingcar.exception.RacingCarException;
import racingcar.exception.car.message.CarNameExceptionMessage;

public class CarNameEmptyException extends RacingCarException {

    public CarNameEmptyException() {
        super(CarNameExceptionMessage.NAME_EMPTY_EXCEPTION_MESSAGE);
    }

}
