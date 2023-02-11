package service;

import dto.RacingRoundStateDto;
import dto.WinnerCarDto;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import model.Car;
import model.Cars;
import service.wrapper.Round;
import utils.RacingNumberGenerator;

public class CarService {

    private Cars cars;
    private Round round;

    public void initCars(Set<String> inputCarsName) {
        cars = new Cars(generateCars(inputCarsName));
    }

    public void initRound(int round) {
        this.round = new Round(round);
    }

    private Set<Car> generateCars(Set<String> carsName) {
        return carsName.stream()
                .map(Car::new)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public List<RacingRoundStateDto> race(RacingNumberGenerator generator) {
        return cars.race(generator, round);
    }

    public List<WinnerCarDto> getWinner() {
        return cars.calculateWinners();
    }
}
