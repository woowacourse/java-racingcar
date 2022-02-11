package racingcargame.controller;

import racingcargame.model.RacingCarGame;
import racingcargame.view.OutputView;

import java.util.List;

public class GameController {
    private static final GameController gameController = new GameController();
    private static InputController inputController = InputController.getInputController();

    private GameController() {
    }

    public static GameController getGameController() {
        return gameController;
    }

    public void runGame() {
        OutputView.showCarNamesInputGuideMessage();
        List<String> carNames = inputController.inputCarName();

        OutputView.showRaceCountInputGuideMessage();
        int raceCount = inputController.inputRaceCount();

        RacingCarGame racingCarGame = new RacingCarGame(carNames, raceCount);

        OutputView.showRaceProgressGuideMessage();
        while (!racingCarGame.isOverRace()) {
            OutputView.showRaceProgress(racingCarGame.startRace());
        }
        OutputView.showGameWinner(racingCarGame.findRacingGameWinner());
    }
}
