package racingcar.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Name {
    private static final Pattern IS_CONSIST_OF_KOREAN_OR_ALPHA = Pattern.compile("^[a-zA-Z가-힣]*$");
    private static final int NAME_LENGTH_LIMIT = 5;
    private final String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    public String value() {
        return name;
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
        return !IS_CONSIST_OF_KOREAN_OR_ALPHA.matcher(name).matches();
    }

    private boolean isExceedNameLength(final String name) {
        return name.length() > NAME_LENGTH_LIMIT;
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
