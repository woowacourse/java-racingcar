package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int INITIAL_DISTANCE = 0;

    private final CarName carName;
    private Integer distance;

    public Car(String carName) {
        this.carName = new CarName(carName);
        distance = INITIAL_DISTANCE;
    }

    public String getCarName() {
        return carName.value();
    }

    public int getDistance() {
        return distance;
    }

    public void move(boolean moveOrStop) {
        if (moveOrStop) {
            distance++;
        }
    }

    public boolean isSameWith(int distance) {
        return this.distance == distance;
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
