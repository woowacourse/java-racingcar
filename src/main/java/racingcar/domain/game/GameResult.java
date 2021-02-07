package racingcar.domain.game;

public class GameResult {
    private final Winners winners;
    private final ExecutionResult executionResult;

    public GameResult(Winners winners, ExecutionResult executionResult) {
        this.winners = winners;
        this.executionResult = executionResult;
    }

    public Winners getWinners() {
        return winners;
    }

    public ExecutionResult getExecutionResult() {
        return executionResult;
    }
}