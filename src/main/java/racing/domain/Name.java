package racing.domain;

import java.util.Objects;

public class Name {

    private static final int MINIMUM_LENGTH_OF_CAR_NAME = 1;
    private static final int MAXIMUM_LENGTH_OF_CAR_NAME = 5;
    private static final String LENGTH_OF_CAR_NAME_ERROR = "[ERROR] 자동차이름의 길이는 1-5자까지 가능합니다.";

    private final String name;

    public Name(String name) {
        validateLengthOfName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(getName(), name1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    private void validateLengthOfName(String name) {
        if (name.length() < MINIMUM_LENGTH_OF_CAR_NAME || name.length() > MAXIMUM_LENGTH_OF_CAR_NAME) {
            throw new IllegalArgumentException(LENGTH_OF_CAR_NAME_ERROR);
        }
    }
}
