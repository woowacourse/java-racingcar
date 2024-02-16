package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final MoveCondition moveCondition;
    private final List<RoundResult> results = new ArrayList<>();

    private RacingGame(Cars cars, MoveCondition moveCondition) {
        this.cars = cars;
        this.moveCondition = moveCondition;
    }

    public static RacingGame of(Cars cars, MoveCondition moveCondition) {

        return new RacingGame(cars, moveCondition);
    }

    public void race(Round round) {
        while (round.isPlayable()) {
            cars.moveAll(moveCondition);
            results.add(cars.buildRoundResult());
            round = round.decrease();
        }
    }

    public List<Car> getCars() {
        return cars.getCars();
    }

    public List<RoundResult> getResult() {
        return results;
    }

    public List<String> findWinnerName() {
        return cars.findWinnerName();
    }
}
