package racingcar.domain;

public class Name {
    private static final int MINIMUM_NUMBER_LENGTH = 1;
    private static final int MAXIMUM_NUMBER_LENGTH = 5;
    private static final String NAME_CONTAINS_BLANK = " ";

    private final String name;

    public Name(final String name) {
        isValidateLength(name);
        isValidateContainBlank(name);
        this.name = name;
    }

    private void isValidateLength(final String name) {
        if (MINIMUM_NUMBER_LENGTH > name.length() || name.length() > MAXIMUM_NUMBER_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 1이상 5이하여야 합니다.");
        }
    }

    private void isValidateContainBlank(final String name) {
        if (name.contains(NAME_CONTAINS_BLANK)) {
            throw new IllegalArgumentException("이름에는 공백이 포함될 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
