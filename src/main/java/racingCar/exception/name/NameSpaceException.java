package racingCar.exception.name;

public class NameSpaceException extends IllegalArgumentException {
    private static final String EXCEPTION_SPACE_MESSAGE = "이름이 공백으로 이뤄져 있습니다";

    public NameSpaceException() {
        super(EXCEPTION_SPACE_MESSAGE);
    }
}
