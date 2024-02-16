package racingcar.dto;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class CarsDto {
    List<CarDto> cars;

    public CarsDto(List<Car> cars) {
        this.cars = cars.stream()
                .map(CarDto::new)
                .toList();
    }

    public List<CarDto> getCars() {
        return cars;
    }
}
