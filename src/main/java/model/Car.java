package model;

import model.dto.CarState;
import model.intgenerator.IntGenerator;
import model.intgenerator.RandomIntGenerator;

public class Car {
    private static final int CONDITION = 4;
    private final String name;
    private final IntGenerator intGenerator;
    private int forwardCount;

    public Car(String name, IntGenerator intGenerator) {
        validate(name);
        this.name = name;
        this.forwardCount = 0;
        this.intGenerator = intGenerator;
    }

    public static Car fromRandomGenerator(String name) {
        return new Car(name, new RandomIntGenerator());
    }

    private void validate(String name) {
        validateNameLength(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 공백 포함 5자 이하여야 한다.");
        }
    }

    public void tryForward() {
        int number = intGenerator.pickNumber();
        if (number >= CONDITION) {
            forwardCount++;
        }
    }

    public CarState captureCarState() {
        return CarState.create(this);
    }

    public String getName() {
        return this.name;
    }

    public int getForwardCount() {
        return this.forwardCount;
    }
}
