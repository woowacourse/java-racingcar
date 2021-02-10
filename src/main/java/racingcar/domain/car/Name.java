package racingcar.domain.car;

import java.util.Objects;
import racingcar.view.ErrorMessages;

public class Name {

    private static final int MAX_LENGTH = 5;

    private final String literal;

    public Name(final String literal) {
        validate(literal);
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }

    private void validate(final String literal) {
        validateMinimum(literal);
        validateMaximum(literal);
    }

    private void validateMaximum(final String literal) {
        if (literal.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NAME_LENGTH);
        }
    }

    private void validateMinimum(final String literal) {
        if (literal.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NONAME);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Name name = (Name) obj;
        return literal.equals(name.literal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(literal);
    }

    @Override
    public String toString() {
        return literal;
    }
}
