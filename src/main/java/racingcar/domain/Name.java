package racingcar.domain;

import java.util.Objects;

public class Name {
    private static final int MINIMUM_LENGTH = 1;
    public static final int MAXIMUM_LENGTH = 5;
    public static final String NULL_ERROR_MESSAGE = ("[ERROR] 자동차 이름은 null이 될 수 없습니다.");
    public static final String LENGTH_ERROR_MESSAGE = ("[ERROR] 자동차 이름은 "
            + MINIMUM_LENGTH + "이상 "
            + MAXIMUM_LENGTH + "이하로 입력해 주세요: ");

    private final String value;

    public Name(final String value) {
        validateNotNull(value);
        validateLength(value);
        this.value = value;
    }

    private void validateNotNull(final String value) {
        if (value == null) {
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
    }

    private void validateLength(final String value) {
        if (value.length() < MINIMUM_LENGTH || value.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE + value);
        }
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
