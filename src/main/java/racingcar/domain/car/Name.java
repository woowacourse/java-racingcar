package racingcar.domain.car;

public class Name {

    private static final int MAX_LENGTH = 5;

    private final String literal;

    public Name(String literal) {
        if (literal.length() == 0 || literal.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 0보다 길고 5보다 같거나 짧아야 합니다.");
        }
        this.literal = literal;
    }

    public String getLiteral() {
        return literal;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
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
    public String toString() {
        return literal;
    }
}
