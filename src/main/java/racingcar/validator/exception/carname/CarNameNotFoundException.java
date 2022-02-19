package racingcar.validator.exception.carname;

public class CarNameNotFoundException extends CarNameException {
    public CarNameNotFoundException() {
        super("모든 자동차 이름은 반드시 존재해야 합니다.");
    }
}
