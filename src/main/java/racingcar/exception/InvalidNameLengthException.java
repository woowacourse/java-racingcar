package racingcar.exception;

public class InvalidNameLengthException extends RacingCarException {

    public InvalidNameLengthException() {
        super("이름의 길이가 올바르지 않습니다.");
    }
}
