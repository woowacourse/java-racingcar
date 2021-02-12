package racingcar.model;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    private final String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException("[Error] 자동차 이름은 1자 이상, 5자 이하여야 합니다.\n");
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
