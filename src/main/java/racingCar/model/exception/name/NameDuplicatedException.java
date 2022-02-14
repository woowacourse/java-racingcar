package racingCar.model.exception.name;

public class NameDuplicatedException extends IllegalArgumentException {
    public static final String EXCEPTION_DUPLICATED_NAME_MESSAGE = "중복된 이름이 입력되었습니다.";

    public NameDuplicatedException() {
        super(EXCEPTION_DUPLICATED_NAME_MESSAGE);
    }
}
