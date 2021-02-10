package racingcar.exception;

public class InvalidPositionException extends RuntimeException {

    private static final String ERROR_MESSAGE = "[ERROR] 위치는 음수가 될 수 없습니다.";

    public InvalidPositionException() {
        super(ERROR_MESSAGE);
    }
}
