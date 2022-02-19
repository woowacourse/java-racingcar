package racingcar.domain;

import java.util.Objects;

public class Name {
    private static final int MINIMUM_LENGTH = 1;
    private static final int MAXIMUM_LENGTH = 5;
    private static final String BLANK = " ";

    private final String name;

    public Name(final String name) {
        isValidateLength(name);
        isValidateContainBlank(name);
        this.name = name;
    }

    private void isValidateLength(final String name) {
        if (MINIMUM_LENGTH > name.length() || name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 1이상 5이하여야 합니다.");
        }
    }

    private void isValidateContainBlank(final String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException("이름에는 공백이 포함될 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Name))
            return false;
        Name name1 = (Name)o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
