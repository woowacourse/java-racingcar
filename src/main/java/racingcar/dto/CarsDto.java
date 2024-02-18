package racingcar.dto;

import racingcar.domain.Car;

import java.util.List;

public class CarsDto {
    private final List<CarDto> cars;

    public CarsDto(final List<Car> cars) {
        this.cars = cars.stream()
                .map(CarDto::new)
                .toList();
    }

    public List<CarDto> getCars() {
        return cars;
    }
}
