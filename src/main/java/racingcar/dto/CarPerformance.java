package racingcar.dto;

import racingcar.domain.Car;

public class CarPerformance {
    private final String carName;
    private final int distance;

    public CarPerformance(Car car) {
        carName = car.getName();
        distance = car.getMovedDistance();
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }
}
