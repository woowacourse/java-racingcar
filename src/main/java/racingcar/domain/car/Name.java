package racingcar.domain.car;

import java.util.Objects;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String ERROR_MESSAGE = "자동차 이름은 1글자 이상 5글자 이하입니다.";

    private final String NAME;

    public Name(String name) {
        validate(name);
        NAME = name;
    }

    private void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return NAME;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name = (Name) o;
        return Objects.equals(NAME, name.NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME);
    }
}
