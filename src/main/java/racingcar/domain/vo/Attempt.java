package racingcar.domain.vo;

import java.util.Objects;
import racingcar.domain.enums.DomainErrorMessage;

public class Attempt {

    private static final int EMPTY_COUNT = 0;
    private static final int ZERO = 0;

    private int attempt;

    public Attempt(String attempt) {
        this.attempt = validate(attempt);
    }

    public boolean isLeft() {
        return attempt > EMPTY_COUNT;
    }

    public void decrease() {
        attempt--;
    }

    private int validate(String attempt) {
        int number = toInteger(attempt);
        validateNegative(number);
        return number;
    }

    private int toInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException(DomainErrorMessage.NUMBER_FORMAT_ERROR_MESSAGE.get());
        }
    }

    private void validateNegative(int attempt) {
        if (attempt < ZERO) {
            throw new RuntimeException(DomainErrorMessage.NUMBER_NEGATIVE_ERROR_MESSAGE.get());
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
