package racingcar.validator.exception;

public class EmptyStringException extends RuntimeException {
    public EmptyStringException() {
        super("빈 문자열을 자동차 이름으로 입력할 수 없습니다.");
    }
}
