package racingcar.domain.exception;

public class RacingGameIsFinishedException extends RacingGameException {

    public static final String ERROR_MESSAGE = "레이싱 게임이 종료됐습니다.";

    public RacingGameIsFinishedException() {
        super(ERROR_MESSAGE);
    }
}
