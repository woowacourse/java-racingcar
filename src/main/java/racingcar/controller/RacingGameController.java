package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameResult;

public class RacingGameController {

    public RacingGameResult startRacingGame(String carNames, int turns) {
        RacingGame racingGame = RacingGame.getRandomNumberRacingGame(carNames, turns);
        RacingGameResult gameResult = racingGame.startGame();

        return gameResult;
    }
}
