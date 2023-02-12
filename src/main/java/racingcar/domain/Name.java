package racingcar.domain;

public class Name {

    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String INVALID_NAME_LENGTH_MESSAGE = "차의 이름은 1자 이상 ~ 5자 이하여야 합니다.";

    private final String value;

    public Name(final String name) {
        validate(name);
        this.value = name;
    }

    private void validate(final String name) {
        if (hasShortLength(name)) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
        }
        if (hasLongLength(name)) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
        }
    }

    private boolean hasShortLength(final String name) {
        return name.length() < MINIMUM_NAME_LENGTH;
    }

    private boolean hasLongLength(final String name) {
        return MAXIMUM_NAME_LENGTH < name.length();
    }

    public String getValue() {
        return value;
    }
}
