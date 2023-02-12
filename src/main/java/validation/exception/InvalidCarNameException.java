package validation.exception;

import validation.ErrorMessages;

public class InvalidCarNameException extends RuntimeException {

    public InvalidCarNameException() {
        super(ErrorMessages.INVALID_CAR_NAME_LENGTH.getMessage());
    }
}
