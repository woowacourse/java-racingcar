package racingcar.domain.game;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.domain.exception.GetWinnerBeforeFinishException;
import racingcar.domain.exception.RacingGameIsFinishedException;
import racingcar.domain.result.MidtermResult;
import racingcar.domain.result.WinnerResult;

public class RacingGame {

    private TryCount tryCount;
    private Cars cars;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void proceedTurn() {
        if (isFinished()) {
            throw new RacingGameIsFinishedException();
        }
        cars.move();
        tryCount.increment();
    }

    public boolean isFinished() {
        return tryCount.isFinished();
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

    public void enrollCars(List<String> names) {
        cars = new Cars(names, randomNumberGenerator);
    }

    public void initTryCount(int inputTryCount) {
        tryCount = new TryCount(inputTryCount);
    }
}
