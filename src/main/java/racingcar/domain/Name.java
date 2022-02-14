package racingcar.domain;

import java.util.Objects;

public class Name {

    private static final int NAME_MAX_LENGTH = 5;

    private static final String NAME_BLANK = " ";
    private static final String NAME_NOT_BLANK = "";

    private final String name;

    public Name(String name) {
        checkNameNull(name);
        checkNameEmpty(name);
        checkNameLength(name);
        this.name = name;
    }

    private void checkNameNull(String name) {
        if (Objects.isNull(name)) {
            throw new IllegalArgumentException("자동차 이름은 null이 들어올 수 없다.");
        }
    }

    private void checkNameEmpty(String name) {
        if (name.equals(NAME_NOT_BLANK)) {
            throw new IllegalArgumentException("자동차 이름은 공백이 들어올 수 없다.");
        }
    }

    private void checkNameLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
    }

    public static Name createNotBlankName(String name) {
        String notBlankName = removeNameBlank(name);
        return new Name(notBlankName);
    }

    private static String removeNameBlank(String name) {
        return name.replaceAll(NAME_BLANK, NAME_NOT_BLANK);
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
