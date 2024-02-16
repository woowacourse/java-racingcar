package model;

import model.dto.CarState;
import model.intgenerator.IntGenerator;
import model.intgenerator.RandomIntGenerator;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MAX_POWER = 9;
    private static final int MIN_FORWARD_POSSIBLE_POWER = 4;

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

    private static void validate(String name) {
        validateNameLength(name);
    }

    private static void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 공백 포함 5자 이하여야 한다.");
        }
    }

    public void tryForward() {
        int power = intGenerator.pickNumber(MAX_POWER);
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

    public boolean hasForwardCount(int targetForwardCount) {
        return this.forwardCount == targetForwardCount;
    }
}
