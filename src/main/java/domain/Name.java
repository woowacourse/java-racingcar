package domain;

import static utils.Validator.validateCarNameLength;

public class Name {

    private final String name;

    public Name(String name) {
        validateCarNameLength(name.length());
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
