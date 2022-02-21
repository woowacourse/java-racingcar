package racingcar.domain.exception;

public class NotFoundCarNameException extends RacingGameException {
    private static final String ERROR_MESSAGE = "의 이름을 가진 자동차가 없습니다.";

    public NotFoundCarNameException(String name) {
        super(name + ERROR_MESSAGE);
    }

}
