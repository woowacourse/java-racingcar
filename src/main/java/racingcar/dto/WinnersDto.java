package racingcar.dto;

import racingcar.domain.Car;
import racingcar.domain.Name;

import java.util.List;
import java.util.stream.Collectors;

public class WinnersDto {
    private final List<CarDto> winnersDto;

    public WinnersDto(List<Car> cars) {
        this.winnersDto = convertCarsToWinnersDto(cars);
    }

    private List<CarDto> convertCarsToWinnersDto(List<Car> cars) {
        return cars.stream()
                .map(CarDto::new)
                .collect(Collectors.toList());
    }

    public List<String> getWinnerNames() {
        return winnersDto.stream()
                .map(CarDto::getNameAsString)
                .collect(Collectors.toList());
    }
}