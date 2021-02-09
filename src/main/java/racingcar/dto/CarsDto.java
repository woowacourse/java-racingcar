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
                .map(CarDto::new)
                .collect(Collectors.toList());
    }

    public List<CarDto> toList() {
        return Collections.unmodifiableList(carsDto);
    }
}