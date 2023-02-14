package dto;

import domain.Car;
import domain.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class CarDto {

    private final String name;
    private final int position;

    private CarDto(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public static CarDto getInstance(final Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }

    public static List<CarDto> getInstances(final Cars cars) {
        return cars.getCars().stream()
                .map(CarDto::getInstance)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
