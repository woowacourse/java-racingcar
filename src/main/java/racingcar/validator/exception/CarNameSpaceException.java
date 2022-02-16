package racingcar.validator.exception;

public class CarNameSpaceException extends RuntimeException {
    public CarNameSpaceException() {
        super("자동차 이름은 공백으로 설정할 수 없습니다.");
    }
}
