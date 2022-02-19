package racingcar.exception.carname;

public class CarNameLineEmptyException extends CarNameException {
    public CarNameLineEmptyException() {
        super("빈 문자열을 자동차 이름으로 입력할 수 없습니다.");
    }
}
