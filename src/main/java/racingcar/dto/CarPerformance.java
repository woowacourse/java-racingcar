package racingcar.dto;

import racingcar.domain.Car;

public class CarPerformance {

    private final String carName;
    private final int distance;

    public CarPerformance(Car car) {
        this.carName = car.getName();
        this.distance = car.getMovedDistance();
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }
}
