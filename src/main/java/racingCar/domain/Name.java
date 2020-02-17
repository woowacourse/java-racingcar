package racingCar.domain;

public class Name {
    private static final int FIVE = 5;

    private final String name;

    public Name(final String name) throws IllegalArgumentException {
        checkIsValidLength(name);
        this.name = name;
    }

    private void checkIsValidLength(String name) throws IllegalArgumentException {
        if (isGreaterThanFive(name) || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isGreaterThanFive(String name) {
        return name.length() > FIVE;
    }

    public boolean equals(Name name) {
        return this.name.equals(name.name);
    }

    public String toString() {
        return name;
    }
}
