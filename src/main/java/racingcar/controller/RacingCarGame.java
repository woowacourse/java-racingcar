package racingcar.controller;

import java.util.function.Supplier;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    public void start() {
        Game game = getGame();
        printResultLine();
        game.proceed();
        OutputView.printWinner(game.getWinner());
    }

    private static void printResultLine() {
        OutputView.printNewLine();
        OutputView.printResultTitle();
    }

    private Game getGame() {
        Cars cars = requestUntilValidated(() -> Cars.from(InputView.readCarNames()));
        return requestUntilValidated(() -> Game.from(InputView.readTryCount(), cars));
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