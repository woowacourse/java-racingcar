package racingcar.model.car;

import java.util.Objects;

import racingcar.dto.CarDto;
import racingcar.util.MovableStrategy;

public class Car implements Comparable<Car> {
    private final Name name;
    private Position position;

    public Car(Name name) {
        this(name, new Position());

    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move(MovableStrategy movableStrategy) {
        if (movableStrategy.isMove()) {
            position = position.increase();
        }
    }

    public CarDto toDto() {
        return new CarDto(name.toString(), position.toInt());
    }

    public Position getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Car car = (Car)object;
        return name.equals(car.name);
    }

    @Override
    public int compareTo(Car car) {
        return position.compareTo(car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
