package racingcar.domain;

public class CarName {
    private static final String NAME_EXCEPTION_MESSAGE = "자동차의 이름은 공백이거나 %d자를 초과할 수 없습니다.";
    private static final int MAXIMUM_LENGTH_OF_NAME = 5;

    private final String name;

    public CarName(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.isBlank() || name.length() > MAXIMUM_LENGTH_OF_NAME) {
            throw new IllegalArgumentException(
                    String.format(NAME_EXCEPTION_MESSAGE, MAXIMUM_LENGTH_OF_NAME));
        }
    }

    public String getName() {
        return name;
    }
}
