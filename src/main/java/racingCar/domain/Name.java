package racingCar.domain;

import java.util.Objects;

public class Name {
    private static final int FIVE = 5;

    private final String name;

    public Name(final String name) throws IllegalArgumentException {
        checkIsValidLength(name);
        this.name = name;
    }

    private void checkIsValidLength(String name) throws IllegalArgumentException {
        if (isGreaterThanFive(name) || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isGreaterThanFive(String name) {
        return name.length() > FIVE;
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

    public boolean equals(Name name) {
        return this.name.equals(name.name);
    }

    public String toString() {
        return name;
    }
}
