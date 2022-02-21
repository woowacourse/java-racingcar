package racingcar.dto;

import racingcar.domain.car.Car;

public class CarResponse {

    private final String name;
    private final int position;

    public CarResponse(Car car) {
        this.name = car.getName();
        this.position = car.getPositionValue();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
