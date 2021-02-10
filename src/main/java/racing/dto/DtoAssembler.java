package racing.dto;

import racing.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class DtoAssembler {

    private DtoAssembler() {
    }

    public static List<CarDto> assembleCars(List<Car> cars) {
        return cars.stream()
                .map(DtoAssembler::assembleCar)
                .collect(Collectors.toList());
    }

    private static CarDto assembleCar(Car car) {
        return new CarDto(car.getName(), car.getPosition());
    }
}
