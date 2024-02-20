package racingcar.controller;

import racingcar.domain.Game;
import racingcar.domain.Cars;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

import java.util.function.Supplier;

public class RacingCarGame {

    public void start() {
        Game game = createGame();
        OutputView.printNewLine();
        OutputView.printResultTitle();
        game.proceed(OutputView::printCarResult);
        OutputView.printWinner(game.getWinner());
    }

    private Game createGame() {
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