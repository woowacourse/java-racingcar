package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class CarRacingGame {
    private final Cars cars;
    private final Round round;

    public CarRacingGame(String inputCars, String inputRound) {
        this.cars = new Cars(inputCars);
        this.round = new Round(inputRound);
    }

    public RaceResult race() {
        RaceResult raceResult = new RaceResult();

        NumberGenerator numberGenerator = new RandomNumberGenerator();
        while (isPlayable()) {
            RoundResult roundResult = playRound(numberGenerator);
            raceResult.record(roundResult);
        }

        return raceResult;
    }

    public boolean isPlayable() {
        return !round.isLast();
    }

    public RoundResult playRound(NumberGenerator numberGenerator) {
        cars.moveCars(numberGenerator);
        round.decrease();

        return new RoundResult(cars.getCars());
    }

    public List<Car> findWinners() {
        return cars.findCarsAtMaxPosition();
    }

    public List<Car> getRoundResult() {
        return Collections.unmodifiableList(cars.getCars());
    }
}
