package racingcar.controller;

import racingcar.model.Round;
import racingcar.view.InputView;

public class GameController {

    private final InputView inputView;

    public GameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String names = inputView.readCarNames();

        String tryRound = inputView.readTryRound();
        Round round = Round.from(tryRound);
    }

}
