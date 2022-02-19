package racingcar.controller;

import racingcar.domain.game.Game;
import racingcar.domain.movement.Movement;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

public class RacingController {
    private final OutputView outputView;
    private final Game game;

    public RacingController(final InputView inputView, final OutputView outputView, final Movement movement) {
        game = new Game(inputView.inputCarNames(), inputView.inputTrialCount(), movement);
        this.outputView = outputView;
    }

    public void run() {
        outputView.printResultMessage();
        while (game.isNotOver()) {
            game.playOneRound();
            outputView.printRoundStatus(game.getRoundResult());
        }
        outputView.printWinners(game.getWinners());
    }
}
