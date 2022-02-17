package racingcar.controller;

import racingcar.domain.Game;
import racingcar.service.DetermineMovement;
import racingcar.service.MoveOrStop;
import racingcar.view.InputView.ConsoleInputView;
import racingcar.view.OutputView.ConsoleOutputView;
import racingcar.view.OutputView.OutputView;

public class RacingController {
    private final OutputView outputView;
    private final MoveOrStop moveOrStop;

    public RacingController(ConsoleOutputView outputView, DetermineMovement moveOrStop) {
        this.outputView = outputView;
        this.moveOrStop = moveOrStop;
    }

    public void run() {
        Game game = new Game(new ConsoleInputView());
        outputView.printResultMessage();

        while(game.isContinue()) {
            game.carsMove(moveOrStop);
            outputView.printRoundStatus(game.carsInfo());
        }

        outputView.printWinners(game.winnerCarsInfo());
    }
}
