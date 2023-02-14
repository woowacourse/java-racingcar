package domain;

import utils.NumberGenerator;

public class Car {

    private static final int DRIVING_DISTANCE = 1;
    private static final int MOVING_STANDARD = 4;
    private static final int NUMBER_MIN_INCLUSIVE = 0;
    private static final int NUMBER_MAX_INCLUSIVE = 9;

    private final CarName name;
    private int drivenDistance = 0;
    private final NumberGenerator numberGenerator;

    public Car(final String name, NumberGenerator numberGenerator) {
        this.name = new CarName(name);
        this.numberGenerator = numberGenerator;
    }

    public void drive() {
        int number = chooseNumber();
        if (number >= MOVING_STANDARD) {
            drivenDistance += DRIVING_DISTANCE;
        }
    }

    private int chooseNumber() {
        int number = numberGenerator.generate();
        validateNumber(number);
        return number;
    }

    private void validateNumber(final int number) {
        final String NOT_PROPER_NUMBER_RANGE = "차량 전진 판별 숫자는 0이상 9이하여야합니다.";

        if (number < NUMBER_MIN_INCLUSIVE || number > NUMBER_MAX_INCLUSIVE) {
            throw new IllegalArgumentException(NOT_PROPER_NUMBER_RANGE);
        }
    }

    public int getDrivenDistance() {
        return drivenDistance;
    }

    public String getName() {
        return name.getName();
    }
}
