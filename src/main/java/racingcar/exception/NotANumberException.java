package racingcar.exception;

public class NotANumberException extends RacingCarException {

    public NotANumberException() {
        super("입력한 문자를 정수로 변환할 수 없습니다.");
    }
}
