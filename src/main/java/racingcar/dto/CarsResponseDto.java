package racingcar.dto;

import racingcar.domain.Car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarsResponseDto {
    private final List<CarResponseDto> carResponseDtoList;

    public CarsResponseDto(List<Car> cars) {
        this.carResponseDtoList = cars.stream()
                .map(car -> new CarResponseDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    public List<CarResponseDto> getCarResponseDtoList() {
        return Collections.unmodifiableList(carResponseDtoList);
    }
}
