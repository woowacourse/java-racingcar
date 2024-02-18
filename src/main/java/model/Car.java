package model;

import model.dto.CarState;
import model.powergenerator.PowerGenerator;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MAX_POWER = 9;
    private static final int MIN_FORWARD_POSSIBLE_POWER = 4;

    private final String name;
    private final PowerGenerator powerGenerator;
    private int forwardCount;

    public Car(String name, PowerGenerator powerGenerator) {
        validate(name);
        this.name = name;
        this.forwardCount = 0;
        this.powerGenerator = powerGenerator;
    }

    private static void validate(String name) {
        validateNameLength(name);
    }

    private static void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 공백 포함 5자 이하여야 한다.");
        }
    }

    public void tryForward() {
        int power = powerGenerator.determinePower(MAX_POWER);
        if (power >= MIN_FORWARD_POSSIBLE_POWER) {
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

    public boolean isSameForwardCount(int targetForwardCount) {
        return this.forwardCount == targetForwardCount;
    }
}
