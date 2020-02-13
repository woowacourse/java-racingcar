package racingcar.domain;

import java.util.Objects;

/**
 * 자동차 이름 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/13
 */
public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String INVALID_CHARACTER = " ";
    public static final String INVALID_NAME_LENGTH_MESSAGE = "Invalid name length.";
    public static final String INVALID_CHARACTER_IN_NAME_MESSAGE = "Invalid character in name.";

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
        if (name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
        }
    }

    private void validateNameHasInvalidCharacter(final String name) {
        if (name.contains(INVALID_CHARACTER)) {
            throw new IllegalArgumentException(INVALID_CHARACTER_IN_NAME_MESSAGE);
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
