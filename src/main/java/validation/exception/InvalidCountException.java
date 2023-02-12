package validation.exception;

import validation.ErrorMessages;

public class InvalidCountException extends RuntimeException {

    public InvalidCountException() {
        super(ErrorMessages.INVALID_COUNT.getMessage());
    }
}
