package racingcar.domain.car;

import java.util.Objects;

import racingcar.domain.movement.MovementStrategy;
import racingcar.exception.NullInstanceException;

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
        validateNull(name, position);
        this.name = name;
        this.position = position;
    }

    private void validateNull(Name name, Position position) {
        if (name == null || position == null) {
            throw new NullInstanceException("Name 혹은 Position 의 인스턴스가 null 입니다.");
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getValue();
    }

    public boolean isSamePosition(int max) {
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
