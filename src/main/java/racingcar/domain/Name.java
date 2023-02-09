package racingcar.domain;

import java.util.Objects;

public class Name {

    private static final int MAX_LENGTH = 5;
    private static final int MIN_LENGTH = 0;

    private final String value;

    public Name(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (name.length() > MAX_LENGTH || name.length() == MIN_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return value.equals(name1.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}