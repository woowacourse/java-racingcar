package racingcargame.controller;

import java.util.List;

import racingcargame.model.RacingCarGame;
import racingcargame.view.OutputView;

public class GameController {
    private static final GameController gameController = new GameController();
    private static InputController inputController = InputController.getInputController();

    private GameController() {
    }

    public static GameController getGameController() {
        return gameController;
    }

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
        List<String> carNames = inputController.inputCarName();

        OutputView.showRaceCountInputGuideMessage();
        int raceCount = inputController.inputRaceCount();

        return new RacingCarGame(carNames, raceCount);
    }
}
