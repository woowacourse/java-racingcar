package racingcar.model;

import java.util.Objects;

public class Name {
    private static final String BLANK = "";
    private static final String SPACE = " ";
    private static final int MAXIMUM_NAME_LENGTH = 10;

    private final String name;

    public Name(String name) {
        this.name = removeBlank(name);
        validateBlank(name);
        validateNameLength(name);
    }

    private String removeBlank(String name) {
        return name.replace(SPACE, BLANK);
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        boolean isValidLength = name.length() <= MAXIMUM_NAME_LENGTH;
        if (!isValidLength) {
            throw new IllegalArgumentException("이름은 10자 이하여야 합니다.");
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
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
