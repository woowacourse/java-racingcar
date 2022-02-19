package racingcar.exception;

public class DuplicateCarNameException extends RuntimeException {

    public DuplicateCarNameException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
