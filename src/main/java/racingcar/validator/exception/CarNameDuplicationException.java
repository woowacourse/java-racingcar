package racingcar.validator.exception;

public class CarNameDuplicationException extends RuntimeException {
    public CarNameDuplicationException() {
        super("자동차 이름은 중복될 수 없습니다.");
    }
}
