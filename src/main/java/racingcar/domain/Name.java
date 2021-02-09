package racingcar.domain;

import java.util.Objects;

public class Name {
    private static final String NAME_LENGTH_ERROR_MSG_FORMAT = "[ERROR] 이름은 %d자 초과 %d자 이하이어야 합니다. 오류 이름 : %s";
    private static final int ZERO = 0;
    private static final int MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        name = name.trim();
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() == ZERO || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(NAME_LENGTH_ERROR_MSG_FORMAT, ZERO, MAX_LENGTH, name));
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Name)) {
            return false;
        }
        Name that = (Name) obj;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
