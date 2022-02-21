package racingcar.domain.vo;

import java.util.Objects;

public class Car implements Comparable<Car> {

    private static final int MOVE_CONDITION = 4;
    private static final int SAME_POSITION = 0;

    private final CarName name;
    private final Position position;

    public Car(CarName carName) {
        this.name = carName;
        this.position = new Position();
    }

    public Car(CarName carName, Position position) {
        this.name = carName;
        this.position = position;
    }

    public CarName getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", position=" + position +
                '}';
    }

    @Override
    public int compareTo(Car car) {
        return position.compareTo(car.position);
    }

    public boolean isSameName(Car car) {
        return car.name.equals(this.name);
    }

    public boolean isSamePosition(Car car) {
        return position.compareTo(car.position) == SAME_POSITION;
    }

    public Car move(int number) {
        if (canMove(number)) {
            return new Car(name, position.increase());
        }
        return this;
    }

    private boolean canMove(int number) {
        return number >= MOVE_CONDITION;
    }
}
