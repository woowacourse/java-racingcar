package racingcar.domain;

import java.util.Objects;

public class Car {
    private static final int OTHER_IS_BIGGER = -1;
    private static final int THIS_IS_BIGGER = 1;
    private static final int SAME = 0;

    private final CarName carName;
    private final Distance distance;

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

    public int orderByDistanceAsc(Car otherCar) {
        if (this.distance.getDistance() > otherCar.getDistance()) {
            return THIS_IS_BIGGER;
        }
        if (this.distance.getDistance() < otherCar.getDistance()) {
            return OTHER_IS_BIGGER;
        }
        return SAME;
    }

    public boolean isSameWith(int distance) {
        return this.distance.isSameWith(distance);
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
