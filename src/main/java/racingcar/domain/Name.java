package racingcar.domain;

import java.util.Objects;

public class Name {
    public static final String BLANK = " ";
    public static final String BLANK_ERROR_MESSAGE = "[ERROR] 공백을 입력할 수 없습니다.";
    public static final String NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 공백을 입력할 수 없습니다.";
    public static final int MINIMUM_NAME_LENGTH = 1;
    public static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateBlankInName(name);
        validateNameLength(name);
        this.name = name;
    }

    public static void validateBlankInName(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }

    public static void validateNameLength(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || MAXIMUM_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return name.equals(name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
