package racingCar.domain;

import java.util.Objects;
import racingCar.domain.moveStrategy.NumGenerator;

public class Car implements Comparable<Car> {
    private static final int GO_NUM = 4;
    private final Name name;
    private final Position position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(NumGenerator numGenerator) {
        if (numGenerator.generate() >= GO_NUM) {
            position.move();
        }
    }

    public boolean isThatPosition(int position) {
        return getPosition() == position;
    }

    public Car getMoreGoCar(Car compareCar) {
        if (compareTo(compareCar) > 0) {
            return this;
        }
        return compareCar;
    }

    public String getName() {
        return name.toString();
    }

    public int getPosition() {
        return position.get();
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.getPosition(), o.getPosition());
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