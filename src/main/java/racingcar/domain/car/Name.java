package racingcar.domain.car;

import racingcar.exception.InvalidCarNameLengthException;

import java.util.Objects;

public class Name {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(final Name name) {
        this.name = name.getValue();
    }

    public Name(final String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new InvalidCarNameLengthException(
                    MIN_NAME_LENGTH, MAX_NAME_LENGTH);
        }

        this.name = name;
    }

    public String getValue() {
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
