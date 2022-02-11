package racingcar.model.car;

import racingcar.util.StringValidator;

import java.util.Objects;

public class Name {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name from(String input) {
        StringValidator.validateIsEmpty(input);
        StringValidator.validateLength(input, MIN_LENGTH, MAX_LENGTH);
        StringValidator.validateFormat(input);

        return new Name(input);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
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
