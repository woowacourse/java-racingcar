package racingcar.domain.data;

import racingcar.utils.InputValidation;

import java.util.Objects;

public class Name {
    private static int NAME_MAX_LENGTH = 5;
    private final String value;

    public Name(String value) {
        InputValidation.validateName(value, NAME_MAX_LENGTH);
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
