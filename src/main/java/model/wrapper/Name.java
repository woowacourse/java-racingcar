package model.wrapper;

import exception.BlankNameException;
import exception.WrongNameLengthException;

public class Name {

    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new BlankNameException();
        }
        if (!validateLength(name)) {
            throw new WrongNameLengthException();
        }
    }

    private boolean validateLength(String name) {
        int length = name.length();

        return length >= NAME_MIN_LENGTH && length <= NAME_MAX_LENGTH;
    }

    public String getName() {
        return name;
    }
}
