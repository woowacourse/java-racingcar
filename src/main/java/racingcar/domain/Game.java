package racingcar.domain;

import java.util.stream.IntStream;
import racingcar.ui.OutputView;

public class Game {
    private static final int NATURAL_NUMBER_BOUNDARY = 0;
    private final int tryCount;
    private final Vehicles vehicles;

    private final CarMoveStrategy carMoveStrategy = new CarMoveStrategy() {
        @Override
        public boolean isMovable(final int value) {
            return CarMoveStrategy.super.isMovable(value);
        }
    };

    public static Game from(final String userTryCount, final Vehicles vehicles) throws NumberFormatException {
        int tryCount = parseUserInput(userTryCount);
        validNaturalNumber(tryCount);
        return new Game(tryCount, vehicles);
    }

    private static void validNaturalNumber(final int tryCount) {
        if (isSmallerThanZero(tryCount)) {
            throw new NumberFormatException();
        }
    }

    private static boolean isSmallerThanZero(final int number) {
        return number <= NATURAL_NUMBER_BOUNDARY;
    }

    private static int parseUserInput(final String userTryCount) {
        return Integer.parseInt(userTryCount);
    }

    private Game(final int tryCount, final Vehicles vehicles) {
        this.tryCount = tryCount;
        this.vehicles = vehicles;
    }

    public void proceed() {
        IntStream.range(0, tryCount).forEach(i -> {
            vehicles.move(carMoveStrategy);
            OutputView.printVehicles(vehicles);
        });
    }

    public Winner getWinner() {
        return Winner.from(vehicles.findFarthestCars());
    }
}
