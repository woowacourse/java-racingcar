package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final List<RoundResult> results;

    public RacingGame(List<Car> cars, MoveCondition moveCondition) {
        this.cars = new Cars(cars, moveCondition);
        this.results = new ArrayList<>();
    }

    public void race(Round round) {
        while (round.isPlayable()) {
            cars.moveAll();
            results.add(cars.buildRoundResult());
            round = round.decrease();
        }
    }

    public List<String> findWinnerName() {
        return cars.findWinnerName();
    }

    public List<RoundResult> getResult() {
        return results;
    }
}
