package racingcar.domain;

import racingcar.util.Validator;

public class Car {

    private final String name;
    private ValueLog valuelog;
    public Car(String name) {
        Validator.validateNameLength(name);
        Validator.validateNotEmptyInput(name);

        this.name = name;
        this.valuelog = new ValueLog();
    }

    public void addValue(int value) {
        valuelog.add(value);
    }


}
