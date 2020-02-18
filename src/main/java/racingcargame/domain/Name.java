package racingcargame.domain;

import racingcargame.exception.CarNameInputException;
import racingcargame.exception.CarNameInputExceptionType;

import java.util.Objects;

public class Name {
    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Name(String name) {
        validate(name);
        this.name = name.trim();
    }

    private void validate(String name) {
        checkNullInput(name);
        name = name.trim();
        checkOverMaxNameLength(name);
        checkBlankInput(name);
    }

    private void checkNullInput(String name) {
        if (name == null) {
            throw new CarNameInputException(CarNameInputExceptionType.NULL_INPUT, "※자동차 이름으로 Null값이 들어옴");
        }
    }

    private void checkOverMaxNameLength(String name) {
        if (MAX_NAME_LENGTH < name.length()) {
            throw new CarNameInputException(CarNameInputExceptionType.OVER_MAX_NAME_LENGTH, "※허용된 길이(5자)를 초과하는 자동차 " +
                    "이름이 존재");
        }
    }

    private void checkBlankInput(String name) {
        if (name.isEmpty()) {
            throw new CarNameInputException(CarNameInputExceptionType.BLANK_NAME, "※이름이 없는 자동차가 존재");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Name name1 = (Name) o;
        return name.equals(name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
