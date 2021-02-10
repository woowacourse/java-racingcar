package racingcar.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Name {
    private static final Pattern PATTERN_ALPHA = Pattern.compile("^[a-zA-z]*$");
    private static final Pattern PATTERN_KOREAN = Pattern.compile("^[가-힣]*$");
    private static final int NAME_LENGTH_LIMIT = 5;

    private final String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (isNullName(name) || isContainInvalidChar(name) || isExceedNameLength(name)) {
            throw new IllegalArgumentException("잘못된 자동차 이름입니다.");
        }
    }

    private boolean isNullName(final String name) {
        return "".equals(name);
    }

    private boolean isContainInvalidChar(final String name) {
        return !PATTERN_ALPHA.matcher(name).matches() && !PATTERN_KOREAN.matcher(name).matches();
    }

    private boolean isExceedNameLength(final String name) {
        return name.length() > NAME_LENGTH_LIMIT;
    }

    public String getName() {
        return name;
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
