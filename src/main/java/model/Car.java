package model;

import model.intgenerator.IntGenerator;

public class Car {
    private static final int CONDITION = 4;
    private final String name;
    private int forwardCount;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.forwardCount = 0;
    }

    private void validate(String name) {
        validateNameLength(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 공백 포함 5자 이하여야 한다.");
        }
    }

    public void tryForward(IntGenerator intGenerator) {
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
