package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.util.RandomNumberGeneratePolicy;
import racingcar.view.InputView;

public class RacingGameController {
    public static void main(String[] args) {
        RacingGame racingGame = RacingGame.createRacingGame(
            InputView.getCarsName(),
            InputView.getRound(),
            new RandomNumberGeneratePolicy()
        );
    }
}
