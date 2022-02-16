package racingcar.exception;

public class InvalidCarNameException extends RuntimeException {

    public InvalidCarNameException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
