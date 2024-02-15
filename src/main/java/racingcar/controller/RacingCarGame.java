package racingcar.controller;

import java.util.function.Supplier;
import racingcar.domain.Game;
import racingcar.domain.Vehicles;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class RacingCarGame {
    public void start() {
        Vehicles vehicles = requestUntilValidated(() -> Vehicles.from(InputView.readCarNames()));
        Game game = requestUntilValidated(() -> Game.from(InputView.readTryCount(), vehicles));
        OutputView.printNewLine();
        OutputView.printResultTitle();
        game.proceed();
        OutputView.printWinner(game.getWinner());
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