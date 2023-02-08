package model.wrapper;

import exception.WrongNameLengthException;

public class Name {

    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        if (!validateLength(name)) {
            throw new WrongNameLengthException();
        }
        this.name = name;
    }

    private boolean validateLength(String name) {
        int length = name.length();

        return length >= NAME_MIN_LENGTH && length <= NAME_MAX_LENGTH;
    }

    public String getName() {
        return name;
    }
}
