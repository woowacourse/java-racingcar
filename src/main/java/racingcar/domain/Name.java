package racingcar.domain;

import java.util.Objects;

public class Name {

    private static final int NAME_LEN = 5;
    private String value;

    public Name(String value) {
        if (value.length() > NAME_LEN) {
            throw new IllegalArgumentException("[Error] 자동차 이름은 5자이하여야 합니다.\n");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
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
        return Objects.equals(value, name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
