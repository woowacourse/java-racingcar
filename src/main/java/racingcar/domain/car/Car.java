package racingcar.domain.car;

import java.util.Objects;

import racingcar.domain.movement.MovementStrategy;

public class Car {

    private final Name name;
    private final Position position;

    public Car(String name) {
        this(new Name(name));
    }

    public Car(Name name) {
        this(name, new Position());
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public boolean isMaxPosition(int max) {
        return position.isSame(max);
    }

    public void move(MovementStrategy strategy) {
        this.position.move(strategy);
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
        return Objects.equals(name, car.name)
            && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
