package calculator.exception;

public class WrongArgumentException extends RuntimeException {

    public WrongArgumentException(NumberExceptionStatus exceptionStatus) {
        super(exceptionStatus.getMessage());
    }

}
