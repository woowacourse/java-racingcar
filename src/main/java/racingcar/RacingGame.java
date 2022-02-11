package racingcar;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.exception.GetWinnersBeforeFinishException;
import racingcar.exception.RacingGameIsFinishedException;
import racingcar.domain.random.RandomNumberGenerator;
import racingcar.domain.result.MidtermResult;
import racingcar.domain.result.WinnersResult;

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

    public WinnersResult getWinnersResult() {
        if (!isFinished()) {
            throw new GetWinnersBeforeFinishException();
        }
        return cars.getWinnersResult();
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
