package dto;

import domain.Car;

public class CarDto {
    private final String name;
    private final Integer position;

    private CarDto(String name, Integer position) {
        this.name = name;
        this.position = position;
    }

    public static CarDto from(Car car) {
        return new CarDto(car.getCarName(), car.getPosition());
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }
}
