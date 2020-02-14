package racing.car;

import racing.car.numbergenerator.NumberGenerator;

import java.util.Objects;

public class Car {

    private static final int STANDARD_FOR_GO = 4;

    private Name name;
    private int distance = 1;

    public Car(Name name) {
        this.name = name;
    }

    public void go(NumberGenerator numberGenerator) {
        int randomNumber = numberGenerator.generate();
        if (randomNumber >= STANDARD_FOR_GO) {
            this.distance++;
        }
    }

    public boolean isWinner(int distance) {
        return this.distance == distance;
    }

    public String getName() {
        return this.name.getName();
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
}
