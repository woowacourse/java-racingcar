package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;

    public RacingGame(List<Car> cars, MoveCondition moveCondition) {
        this.cars = new Cars(cars, moveCondition);
    }

    public List<RoundResult> race(Round round) {
        List<RoundResult> results = new ArrayList<>();

        while (round.isPlayable()) {
            cars.moveAll();
            results.add(cars.buildRoundResult());
            round.decrease();
        }

        return results;
    }

    public List<Car> award() {
        return cars.findWinners();
    }
}
