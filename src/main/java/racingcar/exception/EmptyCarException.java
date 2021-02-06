package racingcar.exception;

public class EmptyCarException extends RuntimeException {
    private static final String MESSAGE = "[ERROR] 자동차는 적어도 한대 있어야 합니다.";

    public EmptyCarException() {
        super(MESSAGE);
    }
}
