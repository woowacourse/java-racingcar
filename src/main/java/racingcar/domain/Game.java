package racingcar.domain;

import java.util.List;
import racingcar.view.log.GameLog;
import racingcar.domain.random.RandomNumberGenerator;
import racingcar.exception.RacingGameIsFinishedException;

public class Game {

    private final Cars cars;
    private final TryCount tryCount;
    private final RandomNumberGenerator randomNumberGenerator;
    private final GameLog gameLog;

    public Game(List<String> names, int tryCount, RandomNumberGenerator randomNumberGenerator) {
        this.cars = new Cars(names);
        this.tryCount = new TryCount(tryCount);
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

    public TryCount getTryCount() {
        return tryCount;
    }

    public GameLog getGameLog() {
        return gameLog;
    }
}
