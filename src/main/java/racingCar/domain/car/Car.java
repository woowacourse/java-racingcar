package racingCar.domain.car;

import java.util.Objects;
import racingCar.domain.car.Engine.Engine;

public class Car {

    private final Name name;
    private final Engine engine;
    private Position position;

    public Car(String name, Engine engine) {
        this(new Name(name), Position.ZERO, engine);
    }

    public Car(String name, int position, Engine engine) {
        this(new Name(name), new Position(position), engine);
    }

    public Car(Name name, Position position, Engine engine) {
        this.name = name;
        this.engine = engine;
        this.position = position;
    }

    public void run() {
        if (engine.movable()) {
            this.position = position.goForward();
        }
    }

    public boolean isOn(Position position) {
        return this.position == position;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
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
        return Objects.equals(name, car.name) &&
            Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }

}
