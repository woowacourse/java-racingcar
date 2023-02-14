package model.car;

import util.validator.CarNameValidator;

public class CarName {

    private final String name;

    public CarName(String name) {
        new CarNameValidator().validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
