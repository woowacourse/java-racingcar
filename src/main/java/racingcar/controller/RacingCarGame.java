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
        game.proceed();
    }

    private <T> T requestUntilValidated(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                OutputView.printInputErrorMessage();
            }
        }
    }
}