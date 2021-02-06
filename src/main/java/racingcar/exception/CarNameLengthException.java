package racingcar.exception;

public class CarNameLengthException extends RuntimeException {
    private static final String MESSAGE = "[ERROR] 자동차 이름은 5 이하여야 합니다.";

    public CarNameLengthException() {
        super(MESSAGE);
    }
}
