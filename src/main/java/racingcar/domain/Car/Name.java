package racingcar.domain.Car;

import racingcar.domain.Car.Exception.NameLengthException;
import racingcar.domain.Car.Exception.NameNullOrEmptyException;

import java.util.Objects;

public class Name {
    private final String name;

    public Name(final String name) {
        this.name = validate(name);
    }

    private String validate(String name) {
        validateNullOrEmpty(name);
        validateLength(name);
        return name.trim();
    }

    private void validateNullOrEmpty(String name) {
        if (name == null || "".equals(name.trim())) {
            throw new NameNullOrEmptyException();
        }
    }

    private void validateLength(String name) {
        name = name.trim();
        if (name.length() < 1 || name.length() > 5) {
            throw new NameLengthException();
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CarName{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(this.name, name.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
