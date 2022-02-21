package racingcar.domain.vo;

import java.util.Objects;

public class Attempt {

    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "시도 회수는 숫자로 입력해야합니다.";
    private static final String NUMBER_NEGATIVE_ERROR_MESSAGE = "시도 회수는 0이상이어야 합니다.";
    private static final int ZERO = 0;

    private final int attempt;

    public Attempt(String input) {
        int attempt = toInteger(input);
        validateNegative(attempt);
        this.attempt = attempt;
    }

    public Attempt(int input) {
        validateNegative(input);
        this.attempt = input;
    }

    private int toInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException numberFormatException) {
            throw new NumberFormatException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    private void validateNegative(int number) {
        if (number < ZERO) {
            throw new IllegalArgumentException(NUMBER_NEGATIVE_ERROR_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Attempt attempt1 = (Attempt) o;
        return attempt == attempt1.attempt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attempt);
    }

    @Override
    public String toString() {
        return "Attempt{" +
                "attempt=" + attempt +
                '}';
    }
}
