package racinggame.race.car;

import racinggame.race.car.engine.Engine;

import java.util.Objects;

public class Car {
    private static final int MINIMUM = 4;

    private final Name name;
    private Distance distance = Distance.startingPosition();

    public Car(String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return this.name.getName();
    }

    public int getDistance() {
        return this.distance.getDistance();
    }

    public void moveWith(Engine engine) {
        int power = engine.getPower();
        if (enough(power)) {
            this.distance = this.distance.move();
        }
    }

    private boolean enough(int power) {
        return power >= MINIMUM;
    }

    public boolean isWinner(int distance) {
        return this.distance.isEqual(distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
                Objects.equals(distance, car.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
