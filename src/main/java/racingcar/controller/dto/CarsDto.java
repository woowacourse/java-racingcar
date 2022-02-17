package racingcar.controller.dto;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;

import racingcar.domain.Cars;

public class CarsDto {
    private final List<CarDto> cars;

    public CarsDto(Cars cars) {
        this.cars = cars.getCars()
            .stream()
            .map(CarDto::new)
            .collect(toList());
    }

    public List<CarDto> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
