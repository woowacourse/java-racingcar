package racingcar.exception;

public class InvalidRacingTimeException extends RuntimeException{
    private static final String ERROR_MESSAGE = "[ERROR] 레이스 횟수는 자연수만 입력 가능합니다.";

    public InvalidRacingTimeException() {
        super(ERROR_MESSAGE);
    }
}
