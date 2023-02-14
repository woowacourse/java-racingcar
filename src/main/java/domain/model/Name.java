package domain.model;

import domain.exception.ErrorCode;
import java.util.Objects;

public class Name {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (isCarNameLengthInRange(name.length())) {
            return;
        }
        throw new IllegalArgumentException(
            String.format(ErrorCode.CAR_NAME_OUT_OF_RANGE.getMessage(), MIN_NAME_LENGTH,
                MAX_NAME_LENGTH));
    }

    private boolean isCarNameLengthInRange(final int nameLength) {
        return nameLength >= MIN_NAME_LENGTH && nameLength <= MAX_NAME_LENGTH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name target = (Name) o;
        return Objects.equals(name, target.name);
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
