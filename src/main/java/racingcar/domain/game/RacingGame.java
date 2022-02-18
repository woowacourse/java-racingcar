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

    private RacingGame(TryCount tryCount, Cars cars) {
        this.tryCount = tryCount;
        this.cars = cars;
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

    public static RacingGameBuilder builder() {
        return new RacingGameBuilderImpl();
    }

    private static class RacingGameBuilderImpl implements RacingGameBuilder {

        private RandomNumberGenerator numberGenerator;
        private Integer tryCount;
        private List<String> carNames;


        public RacingGameBuilder randomNumberGenerator(
            RandomNumberGenerator randomNumberGenerator) {
            this.numberGenerator = randomNumberGenerator;
            return this;
        }

        public RacingGameBuilder tryCount(Integer tryCount) {
            this.tryCount = tryCount;
            return this;
        }

        public RacingGameBuilder carNames(List<String> carNames) {
            this.carNames = carNames;
            return this;
        }

        public RacingGame build() {
            if (numberGenerator == null || tryCount == null || carNames == null) {
                throw new IllegalStateException();
            }

            return new RacingGame(new TryCount(tryCount), new Cars(carNames, numberGenerator));
        }
    }
}
