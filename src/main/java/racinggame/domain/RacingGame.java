package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final List<RoundResult> results;

    private RacingGame(Cars cars) {
        this.cars = cars;
        this.results = new ArrayList<>();
    }

    public static RacingGame of(List<Car> cars, MoveCondition moveCondition) {
        return new RacingGame(new Cars(cars, moveCondition));
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
