package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private Cars cars;
    private Attempt attempt;

    public RacingGame(String[] names, int attempt) {
        this.cars = Cars.from(names);
        this.attempt = new Attempt(attempt);
    }

    public List<ExecutionResult> play() {
        List<ExecutionResult> totalExecutionResult = new ArrayList<>();

        while (!attempt.isOver()) {
            cars.move();
            totalExecutionResult.add(cars.generateExecutionResult());
            attempt.endTurn();
        }

        return totalExecutionResult;
    }

    public List<String> selectWinners() {
        return cars.selectWinners();
    }

}
