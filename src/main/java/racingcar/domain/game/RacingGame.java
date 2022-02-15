package racingcar.domain.game;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.domain.random.RandomNumberGenerator;
import racingcar.exception.RacingGameIsFinishedException;
import racingcar.domain.result.GameLog;

public class RacingGame {

    private final Cars cars;
    private final TryCount tryCount;
    private final RandomNumberGenerator randomNumberGenerator;
    private final GameLog gameLog;

    public RacingGame(List<String> names, int inputTryCount, RandomNumberGenerator randomNumberGenerator) {
        this.cars = new Cars(names);
        this.tryCount = new TryCount(inputTryCount);
        this.randomNumberGenerator = randomNumberGenerator;
        this.gameLog = new GameLog();
    }

    public void proceedTurn() {
        if (isFinished()) {
            throw new RacingGameIsFinishedException();
        }
        cars.move(randomNumberGenerator);
        tryCount.increaseCount();
        gameLog.writeLog(tryCount.getCurrentTryCount(), cars);
    }

    public boolean isFinished() {
        return tryCount.isFinished();
    }

    public GameLog getGameLog() {
        return gameLog;
    }
}
