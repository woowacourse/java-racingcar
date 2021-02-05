package racingcar.domain;

import racingcar.util.CarValidator;

public class Car {
    private final String name;

    public Car(String name) {
        CarValidator.validateCarNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
