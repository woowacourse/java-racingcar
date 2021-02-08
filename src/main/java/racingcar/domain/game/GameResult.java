package racingcar.domain.game;

import racingcar.domain.car.CarName;

import java.util.List;

public class GameResult {
    private final List<CarName> winners;
    private final ExecutionResult executionResult;

    public GameResult(List<CarName> winners, ExecutionResult executionResult) {
        this.winners = winners;
        this.executionResult = executionResult;
    }

    public List<CarName> getWinners() {
        return winners;
    }

    public ExecutionResult getExecutionResult() {
        return executionResult;
    }
}