package racingcar.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CarRacingGame {
    private final Cars cars;
    private final Round round;

    public CarRacingGame(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public List<RoundResult> race() {
        List<RoundResult> roundResults = new LinkedList<>();

        NumberGenerator numberGenerator = new RandomNumberGenerator();
        while (isPlayable()) {
            RoundResult roundResult = playRound(numberGenerator);
            roundResults.add(roundResult);
        }

        return roundResults;
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
