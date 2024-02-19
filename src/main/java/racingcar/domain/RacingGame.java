package racingcar.domain;

import racingcar.domain.gameresult.RacingGameResult;
import racingcar.domain.numericgenerator.RandomNumericGenerator;

public class RacingGame {
    private Cars cars;
    private TryCount tryCount;
    private NumericGenerator generator = new RandomNumericGenerator();
    private GameResult gameResult = new RacingGameResult();

    public RacingGame(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void startGame() {
        while (tryCount.checkTryable()) {
            cars.moveCars(generator);
            gameResult.addGameStatus(cars.getGameStatus());
            tryCount.consume();
        }
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public GameWinner getGameWinner() {
        return cars.calculateWinner();
    }
}
