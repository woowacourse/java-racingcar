package racingcar.exception;

public class NotExistCarsException extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] 게임에 참여한 자동차가 없습니다.";

    public NotExistCarsException() {
        super(ERROR_MESSAGE);
    }
}
