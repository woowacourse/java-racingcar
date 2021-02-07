package racingcar.domain.input.carname.validator.exception;

public class LessThanTwoCarNamesException extends RuntimeException {
    public LessThanTwoCarNamesException(String message) {
        super(message);
    }
}
