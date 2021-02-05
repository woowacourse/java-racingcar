package racingcar.domain;

import racingcar.util.CarValidator;

public class Car {
    private final String name;

    private Car(String name) {
        CarValidator.validateCarNameLength(name);
        this.name = name;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }
}
