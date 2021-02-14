package racingcar.exception;

public class InvalidRacingTimeTypeException extends RuntimeException {

    private static final String ERROR_MESSAGE = "[ERROR] 레이스 횟수는 int 형 타입이어야 합니다.";

    public InvalidRacingTimeTypeException() {
        super(ERROR_MESSAGE);
    }
}
