package racingcar.exception;

public class SingleCarException extends RuntimeException {

    public SingleCarException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
