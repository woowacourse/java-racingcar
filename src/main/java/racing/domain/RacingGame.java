package racing.domain;

import racing.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final RandomNumberGenerator numberGenerator;
    private final Cars cars;

    public RacingGame(List<String> carNames, RandomNumberGenerator numberGenerator) {
        List<Car> cars = parseToCars(carNames);
        this.cars = new Cars(cars);
        this.numberGenerator = numberGenerator;
    }

    private List<Car> parseToCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void play() {
        cars.moveAll(numberGenerator);
    }

    public List<Car> getResult() {
        return cars.getUnmodifiableCars();
    }

    public List<String> getWinners() {
        return cars.decideWinners().stream()
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());
    }
}
