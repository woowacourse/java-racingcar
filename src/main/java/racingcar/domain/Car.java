package racingcar.domain;

import racingcar.vo.Name;

public class Car {
    private static final int ADVANCE_STANDARD = 4;

    private static final int MINIMUM_ADVANCE_RANGE = 0;
    private static final int MAXIMUM_ADVANCE_RANGE = 9;

    private final Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
    }

    public void advance(int power) {
        validateRange(power);
        if (power >= ADVANCE_STANDARD) {
            this.position++;
        }
    }

    public boolean isEqualPosition(Car car) {
        return this.position == car.position;
    }

    public int compareTo(Car car) {
        return this.position - car.getPosition();
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
