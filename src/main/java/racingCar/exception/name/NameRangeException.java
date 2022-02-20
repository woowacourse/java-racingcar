package racingCar.exception.name;

public class NameRangeException extends IllegalArgumentException {
    private static final String EXCEPTION_NAME_RANGE = "이름은 5자 이하만 가능합니다.";

    public NameRangeException() {
        super(EXCEPTION_NAME_RANGE);
    }
}
