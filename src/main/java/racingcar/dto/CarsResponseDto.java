package racingcar.dto;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//TODO
// carResponseDtoList 이름 바꾸기 -> carResponseDtos? carsResponseDto?

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
