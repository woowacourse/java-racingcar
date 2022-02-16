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
        return new CarDto(car.toString(), car.toPosition());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
