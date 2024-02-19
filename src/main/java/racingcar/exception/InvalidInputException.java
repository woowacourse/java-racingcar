package racingcar.exception;

public class InvalidInputException extends BaseException {
    public InvalidInputException(final ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public InvalidInputException(final ErrorMessage errorMessage, final String details) {
        super(errorMessage.getMessage(), details);
    }
}
