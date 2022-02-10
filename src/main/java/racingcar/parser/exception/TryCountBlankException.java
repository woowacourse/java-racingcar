package racingcar.parser.exception;

public class TryCountBlankException extends IllegalArgumentException{
    private static final String MESSAGE = "시도횟수는 공백일 수 없습니다.";

    public TryCountBlankException() {
        super(MESSAGE);
    }
}
