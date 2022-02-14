package racingcar.domain;

import java.util.Objects;

import racingcar.utils.Validator;

public class CarName {
    private final String name;

    public CarName(final String name) {
        Validator.checkName(name);
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        CarName carName = (CarName)other;
        return Objects.equals(name, carName.name);
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
