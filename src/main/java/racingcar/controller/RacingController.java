package racingcar.controller;

import racingcar.domain.Game;
import racingcar.service.DetermineMovementByRandomNumber;
import racingcar.view.InputView.ConsoleInputView;
import racingcar.view.OutputView.ConsoleOutputView;
import racingcar.view.OutputView.OutputView;

public class RacingController {
    private final OutputView outputView;

    public RacingController(ConsoleOutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        Game game = new Game(new ConsoleInputView(), new DetermineMovementByRandomNumber());
        outputView.printResultMessage();

        while(game.isContinue()) {
            game.carsMove();
            outputView.printRoundStatus(game.carsInfo());
        }

        outputView.printWinners(game.winnerCarsInfo());
    }
}
