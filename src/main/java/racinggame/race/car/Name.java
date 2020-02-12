package racinggame.race.car;

import java.util.Objects;

public class Name {
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "%s 는 5글자를 초과한 이름입니다.";
    private static final int MAXIMUM_LENGTH = 5;

    private final String name;

    public Name(String input) {
        validate(input);
        this.name = input;
    }

    public String getName() {
        return name;
    }

    private void validate(String input) {
        if (input.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(String.format(NAME_LENGTH_EXCEPTION_MESSAGE, input));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
