package racingcar.util;

public class CarValidator {
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private CarValidator() {}

    public static void validateCarNameLength(String name) {
        if (name.length() < MIN_CAR_NAME_LENGTH || name.length() > MAX_CAR_NAME_LENGTH) {
            throw new RuntimeException("자동차 이름은 1글자 이상 5글자 이하만 가능하다.");
        }
    }
}
