package racing.car;

import racing.car.numbergenerator.NumberGenerator;

import java.util.Objects;

public class Car {

    private static final int MINIMUM = 4;
    private Name name;
    private int distance;

    public Car(Name name) {
        this.name = name;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance == car.distance &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }

    public void go(NumberGenerator randomNumberGenerator) {
        int randomNumber = randomNumberGenerator.generate();
        if (randomNumber >= MINIMUM) {
            this.distance++;
        }
    }
}
