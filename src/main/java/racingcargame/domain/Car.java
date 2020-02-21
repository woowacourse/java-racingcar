package racingcargame.domain;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private final Name name;
    private Position position;
    private Engine engine;

    public Car(String name) {
        this(name, 0, new LimitEngine());
    }

    public Car(String name, int position) {
        this(name, position, new LimitEngine());
    }

    public Car(String name, int position, Engine engine) {
        this.name = new Name(name);
        this.position = new Position(position);
        this.engine = engine;
    }

    public void go(int randomValue) {
        if (engine.isMovable(randomValue)) {
            position.plus();
        }
    }

    public boolean isSameToPosition(Car car) {
        return position.isSameToPosition(car.position);
    }

    public int getPosition() {
        return position.getValue();
    }

    public String getName() {
        return name.getName();
    }

    @Override
    public int compareTo(Car o) {
        return this.position.compare(o.position);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
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
        return Objects.equals(name, car.name);
    }
}
