package validation.exception;

import validation.ErrorMessages;

public class ContainIdentifierException extends RuntimeException {

    public ContainIdentifierException() {
        super(ErrorMessages.CONTAINS_IDENTIFIER.getMessage());
    }
}
