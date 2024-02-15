package racingcar.domain;

import java.util.stream.IntStream;
import racingcar.ui.OutputView;

public class Game {
    private final int tryCount;
    private final Vehicles vehicles;

    public static Game from(String userTryCount, Vehicles vehicles) throws NumberFormatException {
        int tryCount = parseUserInput(userTryCount);
        validNaturalNumber(tryCount);
        return new Game(tryCount, vehicles);
    }

    private static void validNaturalNumber(int tryCount) {
        if (isSmallerThanZero(tryCount)) {
            throw new NumberFormatException();
        }
    }

    private static boolean isSmallerThanZero(int number) {
        return number <= 0;
    }

    private static int parseUserInput(String userTryCount) {
        return Integer.parseInt(userTryCount);
    }

    private Game(int tryCount, Vehicles vehicles) {
        this.tryCount = tryCount;
        this.vehicles = vehicles;
    }

    public void proceed() {
        IntStream.range(0, tryCount).forEach((i) -> {
            vehicles.move();
            OutputView.printNewLine();
        });
    }

    public Winner getWinner() {
        return Winner.from(vehicles.getBiggestCars());
    }
}
