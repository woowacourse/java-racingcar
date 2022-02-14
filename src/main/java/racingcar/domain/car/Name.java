package racingcar.domain.car;

import java.util.Objects;

public class Name {

    private static final int MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름은 null이 될 수 없습니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다.");
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.");
        }
    }

    public String getName() {
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
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
