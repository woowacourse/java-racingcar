package racingcar.domain;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH
                || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하의 비어있지 않은 이름이어야 합니다.");
        }
    }

    public String getValue() {
        return this.name;
    }
}
