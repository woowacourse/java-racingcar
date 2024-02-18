package racinggame.domain;

import java.util.Objects;

class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name from(String name) {
        checkNameIsEmpty(name);
        checkNameLength(name);

        return new Name(name);
    }

    private static void checkNameIsEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름으로 공백을 입력할 수 없습니다.");
        }
    }

    private static void checkNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("자동차 이름은 최대 %d자 이하만 가능합니다. 입력한 자동차 이름: %s", MAX_NAME_LENGTH, name));
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
