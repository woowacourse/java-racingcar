package utils;

import domain.Car;
import dto.CarDto;
import java.util.ArrayList;
import java.util.List;

public class DtoMapper {
    public static CarDto convert(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

    public static List<CarDto> convert(List<Car> cars) {
        List<CarDto> carDtos = new ArrayList<>();
        for (Car car : cars) {
            carDtos.add(DtoMapper.convert(car));
        }
        return carDtos;
    }
}
