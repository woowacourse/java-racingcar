package racingcar.domain;

import java.util.Objects;

public class Name {
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private final String value;

    private Name(final String value) {
        this.value = value;
    }

    public static Name of(final String value) {
        validateCarNameIsNullOrEmpty(value);
        String trimmedValue = value.trim();
        validateNameLength(trimmedValue);
        return new Name(trimmedValue);
    }

    public static void validateNameLength(String name) {
        if (name.length() < MIN_CAR_NAME_LENGTH || name.length() > MAX_CAR_NAME_LENGTH) {
            throw new RuntimeException("자동차 이름은 1글자 이상 5글자 이하만 가능다.");
        }
    }

    public static void validateCarNameIsNullOrEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 null 이거나 빈 문자열일 수 없습니다.");
        }
    }

    public String getValue() {
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
