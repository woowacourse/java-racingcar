package racingcar.model.car;

import java.util.Objects;

import racingcar.util.StringValidator;

public class Name {
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        StringValidator.validateIsEmpty(name);
        StringValidator.validateLength(name, MIN_LENGTH, MAX_LENGTH);
        StringValidator.validateFormat(name);
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Name name1 = (Name)object;
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
