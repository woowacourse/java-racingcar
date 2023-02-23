package racingcar.domain;

public class Name {
    private static final int NAME_MAX_LENGTH = 5;
    private static final int NAME_MIN_LENGTH = 0;

    private final String value;

    public Name(String value) {
        validateNameLength(value);
        validateNameFormat(value);
        this.value = value;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH || name.length() <= NAME_MIN_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름의 길이는 1부터 5 사이여야 합니다.");
        }
    }

    private void validateNameFormat(String name) {
        if (!name.matches("^[a-zA-Z0-9]*$")) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 영숫자로 이루어져야 합니다.");
        }
    }

    public String getValue() {
        return value;
    }
}
