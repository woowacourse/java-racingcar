package racingcar.domain.exception;

public class GetWinnerBeforeFinishException extends RacingGameException {

    private static final String ERROR_MESSAGE = "게임 종료 전에 우승자를 찾을 수 없습니다.";

    public GetWinnerBeforeFinishException() {
        super(ERROR_MESSAGE);
    }
}
