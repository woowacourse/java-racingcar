package car.domain;

import java.util.Objects;

public class Name {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String LENGTH_EXCEPTION_FORMAT = "이름은 %d글자 이상 %d글자 이하입니다";
    private static final String LENGTH_EXCEPTION_MESSAGE = String.format(LENGTH_EXCEPTION_FORMAT, MIN_LENGTH,
            MAX_LENGTH);

    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public void validateNameLength(String name) {
        if (name.length() < MIN_LENGTH || MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Name name1 = (Name)o;

        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getName() {
        return name;
    }
}
