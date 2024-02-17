package utils;

import domain.Car;
import dto.CarDto;

public class DtoMapper {
    public static CarDto convert(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }
}
