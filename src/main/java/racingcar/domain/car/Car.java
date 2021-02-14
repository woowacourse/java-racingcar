package racingcar.domain.car;

import java.util.Objects;

public class Car {
    private final Name name;
    private Position position;

    private Car(Name name) {
        this(name, Position.valueOf(0));
    }

    private Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public static Car of(Name name) {
        return Car.of(name, Position.valueOf(0));
    }

    public static Car of(Name name, Position position) {
        return new Car(name, position);
    }

    public static Car getInstance(Car car) {
        return new Car(car.getName(), car.getPosition());
    }

    public void tryToMove(int value) {
        this.position.move(value);
    }

    public boolean isSamePosition(Position maxPosition) {
        return this.position.equals(maxPosition);
    }

    public Position getMaxPosition(Position position) {
        return Position.valueOf(this.position.getMaxValue(position));
    }

    public Name getName() {
        return Name.valueOf(name.getValue());
    }

    public Position getPosition() {
        return Position.valueOf(this.position.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(this.name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
