package racingcar.domain.vo;

import java.util.Objects;

public class Name {
    private static final int MAXIMUM_LENGTH = 5;

    private final String name;

    public Name(String name) {
        name = removeLeadingAndTrailingSpace(name);
        validateLength(name);
        this.name = name;
    }

    public String value() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Name)) {
            return false;
        }
        Name name = (Name)o;
        return Objects.equals(this.name, name.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private void validateLength(String name) {
        if (name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 %d글자가 넘을 수 없습니다. :%d", MAXIMUM_LENGTH, name.length()));
        }
    }

    private String removeLeadingAndTrailingSpace(String name) {
        return name.trim();
    }
}
