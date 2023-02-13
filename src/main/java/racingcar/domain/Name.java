package racingcar.domain;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validateNameIsBlank(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameIsBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("[ERROR]: 자동차 이름은 공백을 입력할 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR]: 자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public String getValue() {
        return name;
    }
}
