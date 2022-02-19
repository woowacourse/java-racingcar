package racingcar.domain;

import java.util.Comparator;
import racingcar.domain.vo.Name;

public class Car {
    private static final Comparator<Car> POSITION_COMPARATOR = Comparator.comparingInt(car -> car.position);

    private static final int ADVANCE_STANDARD = 4;

    private static final int MINIMUM_ADVANCE_RANGE = 0;
    private static final int MAXIMUM_ADVANCE_RANGE = 9;

    private final Name name;
    private int position;

    public Car(Name name) {
        this.name = name;
    }

    private Car(Car car) {
        this.name = car.name;
        this.position = car.position;
    }

    public static Car newInstance(Car car) {
        return new Car(car);
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

    public int comparePosition(Car car) {
        return POSITION_COMPARATOR.compare(this, car);
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
