package racingcar.domain.input.carname.validator.exception;

public class DuplicateCarNamesException extends RuntimeException {
    public DuplicateCarNamesException(String message) {
        super(message);
    }
}
