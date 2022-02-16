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
        validate(name, position);
        this.name = name;
        this.position = position;
    }

    private void validate(Name name, Position position) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름은 null이 될 수 없습니다.");
        }
        if (position == null) {
            throw new IllegalArgumentException("자동차 위치는 null이 될 수 없습니다.");
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public boolean isSamePosition(int otherPosition) {
        return position.isSame(otherPosition);
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
