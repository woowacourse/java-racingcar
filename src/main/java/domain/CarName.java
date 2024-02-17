package domain;

import common.exception.model.ValidateException;

public class CarName {
    private final String value;

    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    public static final String CAR_NAME_DOES_NOT_EXIST_ERROR_MESSAGE = "자동차의 이름은 NULL 또는 공백일 수 없습니다.";
    public static final String CAR_NAME_LENGTH_ERROR_MESSAGE = String.format("자동차의 이름 %d 이상, %d 미만 이어야 합니다.", MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH);

    public CarName(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String name) {
        validateName(name);
        validateNameLength(name);
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new ValidateException(CAR_NAME_DOES_NOT_EXIST_ERROR_MESSAGE);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_CAR_NAME_LENGTH || name.length() > MAX_CAR_NAME_LENGTH) {
            throw new ValidateException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public String getValue() {
        return value;
    }
}
