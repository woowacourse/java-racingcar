package racingcar.domain;

import racingcar.util.Validator;

public class Car {

    private final String name;

    public Car(String name) {
        Validator.validateNameLength(name);
        Validator.validateNotEmptyInput(name);

        this.name = name;
    }
}
