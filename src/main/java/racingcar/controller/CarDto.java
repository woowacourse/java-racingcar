package racingcar.controller;

import racingcar.domain.Car;

public class CarDto {
    private final String name;
    private final int position;

    public CarDto(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarDto from(Car car) {
        return new CarDto(car.getName().getNameValue(), car.getPosition().getPositionValue());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
