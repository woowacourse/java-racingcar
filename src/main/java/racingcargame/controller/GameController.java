package racingcargame.controller;

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
        RacingCarGame racingCarGame = new RacingCarGame();

        OutputView.showCarNamesInputGuideMessage();
        racingCarGame.orderToSaveCars(inputController.inputCarName());

        OutputView.showRaceCountInputGuideMessage();
        racingCarGame.orderToSaveRaceCount(inputController.inputRaceCount());
    }
}
