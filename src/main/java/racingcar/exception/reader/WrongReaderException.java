package racingcar.exception.reader;

import racingcar.exception.ExceptionStatus;
import racingcar.exception.WrongArgumentException;

public class WrongReaderException extends WrongArgumentException {

    public WrongReaderException(ExceptionStatus exceptionStatus) {
        super(exceptionStatus);
    }

}
