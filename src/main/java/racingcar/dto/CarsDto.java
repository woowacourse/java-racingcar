package racingcar.dto;

import racingcar.domain.Cars;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarsDto {
    private final List<CarDto> carsDto;

    public CarsDto(Cars cars) {
        this.carsDto = convertCarsToCarsDto(cars);
    }

    private List<CarDto> convertCarsToCarsDto(Cars cars) {
        return cars.getCars()
                .stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    public List<CarDto> getCarsDto() {
        return Collections.unmodifiableList(carsDto);
    }
}