package racingcar.exception;

public class CarMoveCountNegativeException extends RuntimeException {
    private static final String MESSAGE = "이동횟수는 양의 정수로 입력되어야 합니다.";

    public CarMoveCountNegativeException() {
        super(MESSAGE);
    }
}