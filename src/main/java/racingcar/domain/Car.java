package racingcar.domain;

import java.util.Objects;
import racingcar.util.Utils;

public class Car implements Comparable<Car> {
    private static final int MINIMUM_DRIVE_CONDITION = 4;
    private static final int DEFAULT_POSITION_VALUE = 0;

    private final String name;
    private int position = DEFAULT_POSITION_VALUE;

    public Car(String name) {
        this.name = name;
        Utils.validateCarsNameLength(this.name);
        Utils.validateCarsNameBlank(this.name);
    }

    public void drive(int value) {
        if (MINIMUM_DRIVE_CONDITION <= value) {
            this.position++;
        }
    }

    public boolean isSamePosition(Car car) {
        return this.position == car.position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car car) {
        return this.position - car.position;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Car)) {
            return false;
        }
        Car car = (Car) object;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
