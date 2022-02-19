package racingcar.exception;

import racingcar.exception.status.ExceptionStatus;

public class WrongArgumentException extends IllegalArgumentException {

    public WrongArgumentException(final ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }

}
