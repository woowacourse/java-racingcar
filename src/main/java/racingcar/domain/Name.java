package racingcar.domain;

import java.util.Objects;

public class Name {

    private static final int MAX_LENGTH = 5;
    private static final int MIN_LENGTH = 0;

    private final String name;

    public Name(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (name.length() > MAX_LENGTH || name.length() == MIN_LENGTH) {
            throw new IllegalArgumentException();
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