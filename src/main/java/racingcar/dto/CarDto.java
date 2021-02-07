package racingcar.dto;

import racingcar.domain.Car;

public class CarDto {
    private final String name;
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

    public void setPosition(int position) {
        this.position = position;
    }
}