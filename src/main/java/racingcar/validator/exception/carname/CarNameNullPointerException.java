package racingcar.validator.exception.carname;

public class CarNameNullPointerException extends CarNameException {
    public CarNameNullPointerException() {
        super("자동차 이름을 찾을 수 없습니다!");
    }
}
