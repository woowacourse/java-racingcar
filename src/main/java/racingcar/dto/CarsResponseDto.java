package racingcar.dto;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarsResponseDto {
    private final List<CarResponseDto> carsResponseDto;

    public CarsResponseDto(List<Car> cars) {
        this.carsResponseDto = cars.stream()
                .map(car -> new CarResponseDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    public CarsResponseDto(Cars cars) {
        this.carsResponseDto = cars.getCars()
                .stream()
                .map(car -> new CarResponseDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    public List<CarResponseDto> getCarsResponseDto() {
        return Collections.unmodifiableList(carsResponseDto);
    }
}