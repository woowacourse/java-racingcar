package racingcar.dto;

import racingcar.domain.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarsDto {
    private List<String> carNames;
    private List<Integer> carPositions;

    public CarsDto(List<String> carNames, List<Integer> carPositions) {
        this.carNames = carNames;
        this.carPositions = carPositions;
    }

    public static CarsDto from(List<Car> cars) {
        List<String> carNames = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        List<Integer> carPositions = cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
        return new CarsDto(carNames, carPositions);
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public List<Integer> getCarPositions() {
        return carPositions;
    }
}
