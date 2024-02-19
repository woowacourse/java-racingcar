package racingcar.exception;

public class InvalidRoundRangeException extends IllegalArgumentException {

    private static final String MESSAGE = "시도 횟수는 1 이상 입력해 주세요.";

    public InvalidRoundRangeException() {
        super(MESSAGE);
    }
}
