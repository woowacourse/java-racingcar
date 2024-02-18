package racingcar.domain;

import java.util.stream.IntStream;
import racingcar.view.OutputView;

public class Game {
    private final TryCount tryCount;
    private final Cars cars;

    private final CarMoveStrategy carMoveStrategy = new CarMoveStrategy() {
        @Override
        public boolean isMovable(final int value) {
            return CarMoveStrategy.super.isMovable(value);
        }
    };

    public static Game from(final TryCount tryCount, final Cars cars) throws NumberFormatException {
        return new Game(tryCount, cars);
    }

    private Game(final TryCount tryCount, final Cars cars) {
        this.tryCount = tryCount;
        this.cars = cars;
    }

    public void proceed() {
        IntStream.range(0, tryCount.getTryCount()).forEach(i -> {
            cars.move(carMoveStrategy);
            OutputView.printCars(cars);
        });
    }

    public Winner getWinner() {
        return Winner.from(cars.findFarthestCars());
    }
}
