package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int INITIAL_DISTANCE = 0;

    private final CarName carName;
    private Distance distance;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.distance = new Distance();
    }

    public String getCarName() {
        return carName.value();
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public void move(boolean moveOrStop) {
        if (moveOrStop) {
            distance.plus();
        }
    }

    public boolean isSameWith(int distance) {
        return this.distance.getDistance() == distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return distance == car.distance && Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, distance);
    }

}
