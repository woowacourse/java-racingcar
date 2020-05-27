package racing.domain;

public class CarNameEmptyException extends RuntimeException {
    public CarNameEmptyException() {
        super("자동차 이름은 공백일 수 없습니다.");
    }
}
