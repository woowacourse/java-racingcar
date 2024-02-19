package model;

import model.powergenerator.PowerGenerator;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_POWER_FOR_FORWARD = 4;

    private final String name;
    private final PowerGenerator powerGenerator;
    private int forwardCount;

    public Car(String name, PowerGenerator powerGenerator) {
        validate(name);
        this.name = name;
        this.forwardCount = 0;
        this.powerGenerator = powerGenerator;
    }

    private void validate(String name) {
        validateNameLength(name);
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 공백 포함 5자 이하여야 한다.");
        }
    }

    public void tryForward() {
        int power = powerGenerator.generatePower();
        if (power >= MIN_POWER_FOR_FORWARD) {
            forwardCount++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getForwardCount() {
        return this.forwardCount;
    }

    public boolean hasForwardCount(int targetForwardCount) {
        return this.forwardCount == targetForwardCount;
    }
}
