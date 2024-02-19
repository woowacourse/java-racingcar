package racingcar.domain;

import racingcar.ui.OutputView;

import java.util.function.BiConsumer;
import java.util.stream.IntStream;

public class Game {
    private static final int NATURAL_NUMBER_BOUNDARY = 0;
    private final int tryCount;
    private final Cars cars;

    private Game(int tryCount, Cars cars) {
        this.tryCount = tryCount;
        this.cars = cars;
    }

    public static Game from(String rawTryCount, Cars cars) throws NumberFormatException {
        int tryCount = parseUserInput(rawTryCount);
        validNaturalNumber(tryCount);
        return new Game(tryCount, cars);
    }

    private static void validNaturalNumber(int tryCount) {
        if (isSmallerThanZero(tryCount)) {
            throw new NumberFormatException();
        }
    }

    private static boolean isSmallerThanZero(int number) {
        return number <= NATURAL_NUMBER_BOUNDARY;
    }

    private static int parseUserInput(String userTryCount) {
        return Integer.parseInt(userTryCount);
    }

    public void proceed(BiConsumer<String, Integer> doEachCarAfterMove) {
        IntStream.range(0, tryCount).forEach((i) -> {
            cars.move(doEachCarAfterMove);
            OutputView.printNewLine();
        });
    }

    public Winner getWinner() {
        return Winner.from(cars.getBiggestCars());
    }
}
