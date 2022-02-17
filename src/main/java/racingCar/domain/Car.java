package racingCar.domain;

import java.util.Objects;

public class Car {
    private static final int GO_NUM = 4;
    private final Name name;
    private final Position position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void go(int number) {
        if (number >= GO_NUM) {
            position.move();
        }
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car car = (Car) obj;
        return name.equals(car.name) && position.equals(car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}