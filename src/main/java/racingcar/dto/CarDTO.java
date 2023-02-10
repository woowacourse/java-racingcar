package racingcar.dto;

import racingcar.domain.Car;

import java.util.Map;

public class CarDTO {
    private final String carName;
    private final int carPosition;

    public CarDTO(String carName, int carPosition) {
        this.carName = carName;
        this.carPosition = carPosition;
    }

    public String getCarName() {
        return carName;
    }

    public int getCarPosition() {
        return carPosition;
    }
}
