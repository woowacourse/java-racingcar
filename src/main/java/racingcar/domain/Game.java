package racingcar.domain;

import java.util.stream.IntStream;
import racingcar.view.OutputView;

public class Game {
    private final int tryCount;
    private final Cars cars;

    private final CarMoveStrategy carMoveStrategy = new CarMoveStrategy() {
        @Override
        public boolean isMovable(final int value) {
            return CarMoveStrategy.super.isMovable(value);
        }
    };

    public static Game from(final String userTryCount, final Cars cars) throws NumberFormatException {
        int tryCount = parseUserInput(userTryCount);
        validNaturalNumber(tryCount);
        return new Game(tryCount, cars);
    }

    private static void validNaturalNumber(final int tryCount) {
        if (isSmallerThanZero(tryCount)) {
            throw new NumberFormatException();
        }
    }

    private static boolean isSmallerThanZero(final int number) {
        return number <= 0;
    }

    private static int parseUserInput(final String userTryCount) {
        return Integer.parseInt(userTryCount);
    }

    private Game(final int tryCount, final Cars cars) {
        this.tryCount = tryCount;
        this.cars = cars;
    }

    public void proceed() {
        IntStream.range(0, tryCount).forEach(i -> {
            cars.move(carMoveStrategy);
            OutputView.printCars(cars);
        });
    }

    public Winner getWinner() {
        return Winner.from(cars.findFarthestCars());
    }
}
