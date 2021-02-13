package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameResult;
import racingcar.view.GameResultView;

public class RacingGameController {

    public void startRacingGame(String carNames, int turns) {
        RacingGame racingGame = RacingGame.getRandomNumberRacingGame(carNames, turns);
        RacingGameResult gameResult = racingGame.startGame();

        GameResultView.printGameResult(gameResult);
    }
}
