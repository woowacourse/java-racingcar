package dto;

import domain.Car;

public record CarDto(String name, int position) {

    public static CarDto toDto(final Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

}
