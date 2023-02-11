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

    public int getLogSize() {
        return valuelog.size();
    }

    public int getPosition(int step, int threshold) {
        return step * valuelog.stepNumber(threshold);
    }

    public String getName() {
        return name;
    }
}
