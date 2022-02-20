package racingcar.exception;

public class WrongArgumentException extends IllegalArgumentException {

    public WrongArgumentException(final ExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }

}
