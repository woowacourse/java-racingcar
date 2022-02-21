package racingcar.model.car;

import java.util.Objects;

public class Name {
    private static final String FORMAT_PATTERN = "[a-zA-Z0-9ㄱ-ㅎㅏ-ㅣ가-힣]+";
    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String name;

    public Name(final String name) {
        validateIsEmpty(name);
        validateLength(name);
        validateSpecialCharacters(name);
        this.name = name;
    }

    private static void validateIsEmpty(final String text) {
        if (text.isEmpty()) {
            throw new IllegalArgumentException("문자열은 빈값이면 안됩니다.");
        }
    }

    private static void validateLength(final String text) {
        if (text.length() < MIN_LENGTH || text.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                String.format("문자열의 길이가 %d 이상 %d 이하가 아닙니다.", MIN_LENGTH, MAX_LENGTH)
            );
        }
    }

    private static void validateSpecialCharacters(final String text) {
        if (!text.matches(FORMAT_PATTERN)) {
            throw new IllegalArgumentException("올바르지 않은 형식의 문자열입니다.");
        }
    }

    public String value() {
        return name;
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
}
