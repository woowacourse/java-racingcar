package racing.domain;

import java.util.Objects;

public class Car {

    private static final int STANDARD_FOR_GO = 4;

    private Name name;
    private Distance distance;

    public Car(Name name) {
        this.name = name;
        this.distance = new Distance();
    }

    public void go(NumberGenerator numberGenerator) {
        int randomNumber = numberGenerator.generate();
        if (randomNumber >= STANDARD_FOR_GO) {
            this.distance.increase();
        }
    }

    public boolean isWinner(int distance) {
        return this.distance.isEqual(distance);
    }

    public String getName() {
        return this.name.getName();
    }

    public int getDistance() {
        return this.distance.getDistance();
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
