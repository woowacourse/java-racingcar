package validation.exception;

import validation.ErrorMessages;

public class ContainsInvalidWordException extends RuntimeException {

    public ContainsInvalidWordException() {
        super(ErrorMessages.CONTAINS_INVALID_WORD.getMessage());
    }
}
