package domain.vo;

import java.util.Objects;

public class Name {

    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String value;

    public Name(String value) {
        validateLength(value);
        this.value = value;
    }

    private void validateLength(String value) {
        int length = value.strip().length();
        if (length < MINIMUM_NAME_LENGTH || length > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 1글자 이상 5글자여야 합니다. 입력값:" + value);
        }
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
