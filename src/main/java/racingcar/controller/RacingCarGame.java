package racingcar.controller;

import java.util.function.Supplier;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    public void start() {
        Cars cars = requestUntilValidated(() -> Cars.from(InputView.readCarNames()));
        TryCount tryCount = requestUntilValidated(() -> TryCount.from(InputView.readTryCount()));
        Game game = Game.from(tryCount, cars);
        printResultLine();
        game.proceed();
        OutputView.printWinner(game.getWinner());
    }

    private static void printResultLine() {
        OutputView.printNewLine();
        OutputView.printResultTitle();
    }

    private <T> T requestUntilValidated(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            OutputView.printInputErrorMessage();
            return requestUntilValidated(supplier);
        }
    }
}