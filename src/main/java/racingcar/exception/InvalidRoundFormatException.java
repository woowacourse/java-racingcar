package racingcar.exception;

public class InvalidRoundFormatException extends IllegalArgumentException {

    private static final String MESSAGE = "시도 횟수는 숫자만 입력해 주세요.";

    public InvalidRoundFormatException() {
        super(MESSAGE);
    }
}
