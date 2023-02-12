package domain;

import validation.CarNamesValidation;

public class Name {

    private final String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String carName) {
        CarNamesValidation.validateCarName(carName);
    }

    public String getName() {
        return name;
    }
}
