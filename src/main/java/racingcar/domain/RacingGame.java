package racingcar.domain;

import java.util.List;

import racingcar.domain.numericgenerator.RandomNumericGenerator;

import java.util.ArrayList;

public class RacingGame {
    private Cars cars;
    private TryCount tryCount;
    private NumericGenerator generator = new RandomNumericGenerator();
    private List<GameStatus> gameStatus = new ArrayList<>();

    public RacingGame(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void startGame() {
        while (tryCount.checkTryable()) {
            cars.moveCars(generator);
            gameStatus.add(cars.getGameStatus());
            tryCount.consume();
        }
    }

    public GameResult getGameResult() {
        return new GameResult(gameStatus, cars.calculateWinner());
    }
}
