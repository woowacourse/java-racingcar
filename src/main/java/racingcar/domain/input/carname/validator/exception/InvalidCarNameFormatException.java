package racingcar.domain.input.carname.validator.exception;

public class InvalidCarNameFormatException extends RuntimeException {
    public InvalidCarNameFormatException(String message) {
        super(message);
    }
}
