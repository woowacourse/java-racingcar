package racingcar.exception;

public class TryNumberOutOfRangeException extends RacingCarException {

    public TryNumberOutOfRangeException() {
        super("입력한 횟수가 올바르지 않은 범위의 수 입니다.");
    }
}
