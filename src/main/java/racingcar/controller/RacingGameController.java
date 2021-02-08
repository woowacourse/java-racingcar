package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.OutputView;

public class RacingGameController {
    public void play(final Cars carsInGame, final int trialNumber) {
        OutputView.printOutputMessage();
        for (int i = 0; i < trialNumber; i++) {
            carsInGame.singleMove();
        }
        OutputView.printWinner(carsInGame.getWinner());
    }
}

