package racingcar.domain.car;

import java.util.Objects;

public class Name {

    private static final String BLANK = " ";
    private static final int MINIMUM_LENGTH = 1;
    private static final int MAXIMUM_LENGTH = 5;

    private final String name;

    public Name(final String name) {
        validateNull(name);
        validateBlank(name);
        validateLength(name);
        this.name = name;
    }

    private void validateNull(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private void validateBlank(final String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException("이름에 공백이 포함될 수 없습니다.");
        }
    }

    private void validateLength(final String name) {
        if (name.length() < MINIMUM_LENGTH || MAXIMUM_LENGTH < name.length()) {
            throw new IllegalArgumentException("이름의 길이는 1~5 사이여야 합니다.");
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
