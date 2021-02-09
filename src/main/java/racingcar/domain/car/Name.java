package racingcar.domain.car;

import java.util.Objects;
import racingcar.view.ErrorMessages;

public class Name {

    private static final int MAX_LENGTH = 5;

    private final String literal;

    public Name(String literal) {
        if (literal.length() == 0) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NONAME);
        }
        if (literal.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_NAME_LENGTH);
        }
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
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
