package model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import service.NumberGenerator;

public class RacingGame {

    private static final int MAX_RANDOM_NUMBER = 10;

    private final RacingCars racingCars;
    private final NumberGenerator numberGenerator;

    public RacingGame(List<String> carNames, NumberGenerator numberGenerator) {
        this.racingCars = initRacingCars(carNames);
        this.numberGenerator = numberGenerator;
    }

    public Map<String, Integer> playTurn() {
        racingCars.move(numberGenerator, MAX_RANDOM_NUMBER);
        return racingCars.getCurrentPositions();
    }

    public Map<String, Integer> getCurrentStatus() {
        return racingCars.getCurrentPositions();
    }

    public List<String> getResult() {
        return racingCars.findWinner();
    }

    private RacingCars initRacingCars(final List<String> names) {
        return new RacingCars(names.stream()
            .map(Car::new)
            .collect(Collectors.toList()));
    }

}
