package racingcar.domain.game;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.domain.exception.GetWinnerBeforeFinishException;
import racingcar.domain.result.MidtermResult;
import racingcar.domain.result.WinnerResult;

public class RacingGame {

    private final TryCount tryCount;
    private final Cars cars;

    public RacingGame(int tryCount, List<String> names, RandomNumberGenerator generator) {
        this.tryCount = new TryCount(tryCount);
        this.cars = new Cars(names, generator);
    }

    public void proceedTurn() {
        tryCount.increment();
        cars.move();
    }

    public boolean isFinished() {
        return tryCount.isReachedMaxCount();
    }

    public WinnerResult getWinnerResult() {
        if (!isFinished()) {
            throw new GetWinnerBeforeFinishException();
        }
        return cars.getWinnerResult();
    }

    public MidtermResult getMidtermResult() {
        return cars.getMidtermResult();
    }
}
