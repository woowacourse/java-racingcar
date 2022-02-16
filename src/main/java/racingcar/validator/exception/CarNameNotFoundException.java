package racingcar.validator.exception;

public class CarNameNotFoundException extends RuntimeException {
    public CarNameNotFoundException() {
        super("모든 자동차 이름은 반드시 존재해야 합니다.");
    }
}
