package racingcar.exception.carname;

public class CarNameNotExistsException extends CarNameException {
    public CarNameNotExistsException() {
        super("모든 자동차 이름은 반드시 존재해야 합니다.");
    }
}
