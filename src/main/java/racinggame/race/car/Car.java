package racinggame.race.car;

import racinggame.race.car.engine.Engine;

import java.util.Objects;

public class Car {
    private final Name name;
    private Distance distance = Distance.startingPosition();
    private Engine engine;

    public Car(String name, Engine engine) {
        this.name = new Name(name);
        this.engine = engine;
    }

    public String getName() {
        return this.name.getName();
    }

    public int getDistance() {
        return this.distance.getDistance();
    }

    public void move() {
        if (engine.enoughPower()) {
            this.distance = this.distance.move();
        }
    }

    public boolean isSameDistance(int distance) {
        return this.distance.isEqual(distance);
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
                Objects.equals(distance, car.distance) &&
                Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance, engine);
    }
}
