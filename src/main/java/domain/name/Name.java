package domain.name;

import java.util.Objects;

public class Name {
    private static final Integer LENGTH_LIMIT = 5;
    private String value;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("공백 이름입니다!");
        }
        if (value.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException(String.format("이름은 최대 %d 글자입니다!", LENGTH_LIMIT));
        }
    }

    @Override
    public boolean equals(final Object o) {
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
        return Objects.hashCode(value);
    }

    public String getValue() {
        return value;
    }
}
