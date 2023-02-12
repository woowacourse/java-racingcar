package validation.exception;

import validation.ErrorMessages;

public class NotNumberException extends RuntimeException {

    public NotNumberException() {
        super(ErrorMessages.NOT_A_NUMBER.getMessage());
    }
}
