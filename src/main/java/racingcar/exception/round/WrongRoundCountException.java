package racingcar.exception.round;

import racingcar.exception.ExceptionStatus;
import racingcar.exception.WrongArgumentException;

public class WrongRoundCountException extends WrongArgumentException {

    public WrongRoundCountException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus);
    }

}
