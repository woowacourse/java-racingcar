package racingCar.model;

import java.util.regex.Pattern;
import racingCar.model.exception.name.NameRangeException;
import racingCar.model.exception.name.NameSpaceException;
import racingCar.model.exception.name.NameSpecialCharException;

public class Name {
    private static final String NOT_SPECIAL_REGEX = "[가-힣\\w_]*";
    private static final int maxNameSize = 5;

    public final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.trim().isEmpty()) {
            throw new NameSpaceException();
        }
        if (name.length() > maxNameSize) {
            throw new NameRangeException();
        }
        if (!Pattern.matches(NOT_SPECIAL_REGEX, name)) {
            throw new NameSpecialCharException();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
