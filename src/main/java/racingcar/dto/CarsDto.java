package racingcar.dto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Cars;

public class CarsDto {

    List<CarDto> cars;

    public CarsDto(Cars cars) {
        this.cars = cars.getCars().stream()
            .map(CarDto::new)
            .collect(Collectors.toList());
    }

    public List<CarDto> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
