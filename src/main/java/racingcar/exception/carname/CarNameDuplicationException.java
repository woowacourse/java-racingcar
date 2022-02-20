package racingcar.exception.carname;

public class CarNameDuplicationException extends CarNameException {
    public CarNameDuplicationException() {
        super("자동차 이름은 중복될 수 없습니다.");
    }
}
