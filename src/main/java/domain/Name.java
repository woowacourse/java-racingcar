package domain;

import static exception.ErrorMessage.ENTER_NAME_CORRECT_LENGTH;

import exception.NameIsOutOfBoundException;

public class Name {

    private static final int MAX_LENGTH = 5;
    private static final int MIN_LENGTH = 1;

    private final String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        validateLength(name);
    }

    private void validateLength(final String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new NameIsOutOfBoundException(ENTER_NAME_CORRECT_LENGTH.toString());
        }
    }

    public String getName() {
        return this.name;
    }
}

