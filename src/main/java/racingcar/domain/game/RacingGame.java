package racingcar.domain.game;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.domain.random.RandomNumberGenerator;
import racingcar.exception.GetWinnersBeforeFinishException;
import racingcar.exception.RacingGameIsFinishedException;
import racingcar.domain.result.MidtermResult;
import racingcar.domain.result.WinnersResult;

public class RacingGame {

    private final RandomNumberGenerator randomNumberGenerator;

    private Cars cars;
    private TryCount tryCount;

    public RacingGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void proceedTurn() {
        if (isFinished()) {
            throw new RacingGameIsFinishedException();
        }
        cars.move(randomNumberGenerator);
        tryCount.increment();
    }

    public boolean isFinished() {
        return tryCount.isFinished();
    }

    public MidtermResult getMidtermResult() {
        return cars.getMidtermResult();
    }

    public WinnersResult getWinnersResult() {
        if (!isFinished()) {
            throw new GetWinnersBeforeFinishException();
        }
        return cars.getWinnersResult();
    }

    public void enrollCars(List<String> names) {
        cars = new Cars(names);
    }

    public void initTryCount(int inputTryCount) {
        tryCount = new TryCount(inputTryCount);
    }
}
