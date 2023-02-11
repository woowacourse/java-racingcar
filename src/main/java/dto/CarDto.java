package dto;

import domain.Car;

public class CarDto {

    private final String name;
    private final int position;

    private CarDto(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public static CarDto from(final Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
