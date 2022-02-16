package racingcar.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int MINIMUM_DRIVE_CONDITION = 4;
    private static final int DEFAULT_POSITION_VALUE = 0;
    private final Name name;
    private int position = DEFAULT_POSITION_VALUE;

    private Car(Name name) {
        this.name = name;
    }

    public static Car fromName(Name name) {
        return new Car(name);
    }

    private static void validateCar(String carName) {
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

    public int toPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name.toString();
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
