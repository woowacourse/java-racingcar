package racingcar.model;

public class Name {
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;

    private final String name;

    public Name(String name) {
        this.name = name;
        validateCarName(name);
    }

    private void validateCarName(String name) {
        validateBlank(name);
        validateNameLength(name);
    }

    private void validateBlank(String name) {
        boolean isValid = name.length() >= MINIMUM_CAR_NAME_LENGTH;
        if (!isValid) {
            throw new IllegalArgumentException("자동차 이름에 공백일 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        boolean isValidLength = name.length() <= MAXIMUM_CAR_NAME_LENGTH;
        if (!isValidLength) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
