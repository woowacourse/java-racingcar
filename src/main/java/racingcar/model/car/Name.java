package racingcar.model.car;

import java.util.Objects;

public class Name {
    private static final String FORMAT_PATTERN = "[a-zA-Z0-9ㄱ-ㅎㅏ-ㅣ가-힣]+";
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateIsEmpty(name);
        validateLength(name, MIN_LENGTH, MAX_LENGTH);
        validateFormat(name);
        this.name = name;
    }

    private static void validateIsEmpty(String text) {
        if (text.isEmpty()) {
            throw new IllegalArgumentException("문자열은 빈값이면 안됩니다.");
        }
    }

    private static void validateLength(String text, int min, int max) {
        if (text.length() < min || text.length() > max) {
            throw new IllegalArgumentException(
                String.format("문자열의 길이가 %d 이상 %d 이하가 아닙니다.", min, max)
            );
        }
    }

    private static void validateFormat(String text) {
        if (!text.matches(FORMAT_PATTERN)) {
            throw new IllegalArgumentException("올바르지 않은 형식의 문자열입니다.");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Name name1 = (Name)object;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
