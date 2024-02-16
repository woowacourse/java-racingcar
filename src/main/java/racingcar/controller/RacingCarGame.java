package racingcar.controller;

import java.util.function.Supplier;
import racingcar.domain.Game;
import racingcar.domain.Vehicles;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

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
        Vehicles vehicles = requestUntilValidated(() -> Vehicles.from(InputView.readCarNames()));
        return requestUntilValidated(() -> Game.from(InputView.readTryCount(), vehicles));
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