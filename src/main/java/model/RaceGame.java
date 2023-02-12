package model;

import dto.RacingRoundStateDto;
import dto.WinnerCarDto;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import model.wrapper.Round;
import utils.RacingNumberGenerator;

public class RaceGame {

    private final RacingNumberGenerator generator;
    private Cars cars;
    private Round round;

    public RaceGame(RacingNumberGenerator generator) {
        this.generator = generator;
    }

    public void initCars(Set<String> inputCarsName) {
        this.cars = new Cars(generateCars(inputCarsName));
    }

    private Set<Car> generateCars(Set<String> carsName) {
        return carsName.stream()
                .map(Car::new)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public void initRound(int round) {
        this.round = new Round(round);
    }

    public List<RacingRoundStateDto> race() {
        return cars.race(generator, round);
    }

    public List<WinnerCarDto> calculateWinners() {
        return cars.calculateWinners();
    }
}
