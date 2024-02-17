package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Cars cars;
    private final MoveCondition moveCondition;

    private RacingGame(Cars cars, MoveCondition moveCondition) {
        this.cars = cars;
        this.moveCondition = moveCondition;
    }

    public static RacingGame of(Cars cars, MoveCondition moveCondition) {

        return new RacingGame(cars, moveCondition);
    }

    public List<RoundResult> race(Round round) {
        List<RoundResult> results = new ArrayList<>();
        while (round.isPlayable()) {
            cars.moveAll(moveCondition);
            results.add(cars.buildRoundResult());
            round = round.decrease();
        }
        
        return results;
    }

    public List<String> findWinnerName() {
        return cars.findWinnerName();
    }
}
