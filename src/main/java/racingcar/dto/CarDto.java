package racingcar.dto;

import racingcar.domain.car.Car;

public class CarDto {

    private String name;
    private int position;

    public CarDto(Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
