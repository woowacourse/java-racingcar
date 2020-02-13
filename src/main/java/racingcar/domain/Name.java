package racingcar.domain;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String INVALID_CHARACTER = " ";

    private final String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateName(final String name) {
        Objects.requireNonNull(name);
        validateNameLength(name);
        validateNameHasInvalidCharacter(name);
    }

    private void validateNameLength(final String name) {
        if (name.length()>MAX_NAME_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException("이름의 길이가 올바르지 않습니다.");
        }
    }

    private void validateNameHasInvalidCharacter(final String name) {
        if (name.contains(INVALID_CHARACTER)) {
            throw new IllegalArgumentException("이름에 유효하지 않은 문자가 있습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
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
