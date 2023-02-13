package racingcar.domain;

import static java.text.MessageFormat.format;

import java.util.Objects;

public class Name {

    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String INVALID_NAME_LENGTH_MESSAGE =
            "입력된 차 이름[{0}]: 차의 이름은 " + MINIMUM_NAME_LENGTH + "자 이상 ~ " + MAXIMUM_NAME_LENGTH + "자 이하여야 합니다.";

    private final String value;

    public Name(final String name) {
        validate(name);
        this.value = name;
    }

    private void validate(final String name) {
        if (hasShortLength(name) || hasLongLength(name)) {
            throw new IllegalArgumentException(format(INVALID_NAME_LENGTH_MESSAGE, name));
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name = (Name) o;
        return Objects.equals(getValue(), name.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
