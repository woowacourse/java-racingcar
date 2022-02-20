package racingcar.exception.car;

import racingcar.exception.ExceptionStatus;
import racingcar.exception.WrongArgumentException;

public class WrongCarNameException extends WrongArgumentException {

    public WrongCarNameException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus);
    }

}
