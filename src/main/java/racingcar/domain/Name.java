package racingcar.domain;

public class Name {
    private static final String NAME_LENGTH_RANGE_ERROR = "자동차 이름은 1글자 이상 5글자 이하입니다.";
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_RANGE_ERROR);
        }
    }

    public String getName() {
        return name;
    }
}
