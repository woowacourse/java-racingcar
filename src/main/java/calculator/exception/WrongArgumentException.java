package calculator.exception;

public class WrongArgumentException extends RuntimeException {

    public WrongArgumentException(final NumberExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }

}
