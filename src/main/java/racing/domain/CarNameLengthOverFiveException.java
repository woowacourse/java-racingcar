package racing.domain;

public class CarNameLengthOverFiveException extends RuntimeException {
    public CarNameLengthOverFiveException() {
        super("자동차 이름은 5글이 이하만 가능합니다.");
    }
}
