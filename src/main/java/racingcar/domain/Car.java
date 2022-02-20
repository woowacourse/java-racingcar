package racingcar.domain;

import racingcar.domain.vo.Name;

public class Car {
    public static Car ZERO_POSITION = Car.motionlessCar();

    private static final int MOTIONLESS_POSITION = 0;
    private static final int ADVANCE_STANDARD = 4;

    private static final int MINIMUM_ADVANCE_RANGE = 0;
    private static final int MAXIMUM_ADVANCE_RANGE = 9;

    private Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
    }

    private Car(int position) {
        this.position = position;
    }

    private static Car motionlessCar() {
        return new Car(MOTIONLESS_POSITION);
    }

    public void advance(int power) {
        validateRange(power);
        if (power >= ADVANCE_STANDARD) {
            this.position++;
        }
    }

    public boolean isGreaterThan(Car otherCar) {
        return this.position >= otherCar.position;
    }

    public boolean isEqualPosition(Car car) {
        return this.position == car.position;
    }

    public Name getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateRange(int number) {
        if (number < MINIMUM_ADVANCE_RANGE || number > MAXIMUM_ADVANCE_RANGE) {
            throw new IllegalArgumentException("유효한 범위가 아닙니다.");
        }
    }
}
