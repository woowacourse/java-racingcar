package racingcar.domain;

public class Name {

    private static final int NAME_LOWER_BOUND = 1;
    private static final int NAME_UPPER_BOUND = 5;
    private static final String INVALID_NAME_LENGTH_MESSAGE =
            "차의 이름은 " + NAME_LOWER_BOUND + "자 이상, " + NAME_UPPER_BOUND + "자 이하여야 합니다. 입력된 차 이름 : ";

    private final String value;

    Name(final String name) {
        validate(name);
        this.value = name;
    }

    private void validate(final String name) {
        if (isInvalidNameLength(name)) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE + name);
        }
    }

    private boolean isInvalidNameLength(final String name) {
        return name.length() < NAME_LOWER_BOUND || NAME_UPPER_BOUND < name.length();
    }

    public String getValue() {
        return value;
    }
}
