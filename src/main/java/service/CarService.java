package service;

import dto.RacingCarStateDto;
import dto.WinnerCarDto;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import model.Car;
import model.Cars;
import utils.RacingNumberGenerator;

public class CarService {

    private Cars cars;

    public void initCars(Set<String> inputCarsName) {
        cars = new Cars(generateCars(inputCarsName));
    }

    private Set<Car> generateCars(Set<String> carsName) {
        return carsName.stream()
                .map(Car::new)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public void race(RacingNumberGenerator generator) {
        cars.race(generator);
    }

    public List<RacingCarStateDto> getRacingCarStateDto() {
        return cars.getRacingCarStateDto();
    }

    public List<WinnerCarDto> getWinner() {
        return cars.calculateWinners();
    }
}
