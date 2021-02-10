package racingcar.domain.car;

import java.util.Objects;
import racingcar.exception.InvalidCarNameException;

public class Name {

    private static final int CAR_NAME_LENGTH_START_INCLUSIVE = 1;
    private static final int CAR_NAME_LENGTH_END_INCLUSIVE = 5;

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name of(String name) {
        validationName(name);
        return new Name(name);
    }

    private static void validationName(String name) {
        if (name.length() < CAR_NAME_LENGTH_START_INCLUSIVE || name.length() > CAR_NAME_LENGTH_END_INCLUSIVE) {
            throw new InvalidCarNameException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
        }
    }

    public String getValue() {
        return name;
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

        return name.equals(name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
