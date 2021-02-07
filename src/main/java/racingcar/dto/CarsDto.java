package racingcar.dto;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarsDto {
    private final List<CarDto> carsResponseDto;

    public CarsDto(List<Car> cars) {
        this.carsResponseDto = cars.stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    public CarsDto(Cars cars) {
        this.carsResponseDto = cars.getCars()
                .stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    public List<CarDto> getCarsResponseDto() {
        return Collections.unmodifiableList(carsResponseDto);
    }
}