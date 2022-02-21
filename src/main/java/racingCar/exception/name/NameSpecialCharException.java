package racingCar.exception.name;

public class NameSpecialCharException extends IllegalArgumentException {
    private static final String EXCEPTION_SPACIAL_MESSAGE = "이름에는 특수문자가 입력될 수 없습니다.";

    public NameSpecialCharException() {
        super(EXCEPTION_SPACIAL_MESSAGE);
    }
}
