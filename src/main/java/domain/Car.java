package domain;

import utils.NumberGenerator;

public class Car {

    private final String name;
    private int drivenDistance = 0;
    private final NumberGenerator numberGenerator;

    public Car(final String name, NumberGenerator numberGenerator) {
        validateLength(name);
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public void drive() {
        final int DRIVING_DISTANCE = 1;
        final int MOVING_STANDARD = 4;

        int number = chooseNumber();
        if (number >= MOVING_STANDARD) {
            drivenDistance += DRIVING_DISTANCE;
        }
    }

    private int chooseNumber() {
        return numberGenerator.generate();
    }

    public int getDrivenDistance() {
        return drivenDistance;
    }

    public String getName() {
        return name;
    }

    private void validateLength(final String carName) {
        final String NOT_PROPER_CAR_NAME_LENGTH = "[ERROR] 자동차 이름 길이는 %d자 이상, %d자 이하여야합니다.";
        final int MIN_CAR_NAME_LENGTH = 1;
        final int MAX_CAR_NAME_LENGTH = 5;

        if (carName.length() < MIN_CAR_NAME_LENGTH || carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(
                String.format(NOT_PROPER_CAR_NAME_LENGTH, MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH));
        }
    }
}
