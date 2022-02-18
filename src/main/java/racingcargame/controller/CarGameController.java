package racingcargame.controller;

import racingcargame.model.RacingCarGame;
import racingcargame.view.InputView;
import racingcargame.view.OutputView;

public class CarGameController {

    public void playGame() {
        RacingCarGame racingCarGame = makeRacingCarGameObjectByUserInput();

        OutputView.showRaceProgressGuideMessage();
        while (!racingCarGame.isOverRace()) {
            OutputView.showRaceProgress(racingCarGame.startRace());
        }
        OutputView.showGameWinner(racingCarGame.findRacingGameWinner());
    }

    private RacingCarGame makeRacingCarGameObjectByUserInput() {
        OutputView.showCarNamesInputGuideMessage();
        String carNames = InputView.inputCarName();

        OutputView.showRaceCountInputGuideMessage();
        String raceCount = InputView.inputRaceCount();

        return new RacingCarGame(carNames, raceCount);
    }
}
