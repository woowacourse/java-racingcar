package racingCar.domain;

import java.util.Objects;
import java.util.regex.Pattern;
import racingCar.exception.name.NameRangeException;
import racingCar.exception.name.NameSpaceException;
import racingCar.exception.name.NameSpecialCharException;

public class Name {
    private static final String NOT_SPECIAL_REGEX = "[가-힣\\w_]*";
    private static final int MAX_NAME_SIZE = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.trim().isEmpty()) {
            throw new NameSpaceException();
        }
        if (name.length() > MAX_NAME_SIZE) {
            throw new NameRangeException();
        }
        if (!Pattern.matches(NOT_SPECIAL_REGEX, name)) {
            throw new NameSpecialCharException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Name objName = (Name) obj;
        return Objects.equals(name, objName.name);
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