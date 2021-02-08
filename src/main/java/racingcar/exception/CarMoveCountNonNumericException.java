package racingcar.exception;

public class CarMoveCountNonNumericException extends RuntimeException {
    private static final String MESSAGE = "이동횟수는 숫자로 입력되어야 합니다.";

    public CarMoveCountNonNumericException() {
        super(MESSAGE);
    }
}
