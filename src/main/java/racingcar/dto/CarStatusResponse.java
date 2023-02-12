package racingcar.dto;

import racingcar.domain.Car;

public class CarStatusResponse {
    private final String carName;
    private final int carPosition;

    public CarStatusResponse(Car car) {
        this.carName = car.getName();
        this.carPosition = car.getPosition();
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }
}
