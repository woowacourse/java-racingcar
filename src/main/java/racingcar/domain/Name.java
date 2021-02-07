package racingcar.domain;

import java.util.Objects;

public class Name {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String EMPTY = " ";
    private static final String EMPTY_ERR_MSG = ERROR_PREFIX + "이름으로 공백을 입력할 수 없습니다.";
    private static final String LENGTH_ERR_MSG = ERROR_PREFIX + "이름은 1자 이상, 5자 이내만 가능합니다.";
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Name(final String name) {
        checkNameValidation(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkNameValidation(final String name) {
        isEmpty(name);
        isLetterMoreThan1LessThan5(name);
    }

    private void isEmpty(final String name) {
        if (name.equals(EMPTY)) {
            throw new IllegalArgumentException(EMPTY_ERR_MSG);
        }
    }

    private void isLetterMoreThan1LessThan5(final String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERR_MSG);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Name)) {
            return false;
        }
        Name newName = (Name) o;
        return name.equals(newName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
