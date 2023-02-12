package model;

import dto.CarDto;
import dto.WinnerCarDto;
import java.util.List;
import java.util.stream.Collectors;
import utils.RacingNumberGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void race(RacingNumberGenerator generator) {
        cars.forEach(car -> car.race(generator));
    }

    public List<CarDto> getCarsDto() {
        return cars.stream()
                .map(car -> new CarDto(car.getName(), car.getPosition()))
                .collect(Collectors.toList());
    }

    public List<WinnerCarDto> getWinner() {
        Car winner = cars.stream()
                .max(Car::compareTo)
                .orElse(null);

        return sortWinner(winner);
    }

    private List<WinnerCarDto> sortWinner(Car winner) {
        return cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .map(car -> new WinnerCarDto(car.getName()))
                .collect(Collectors.toUnmodifiableList());
    }
}
