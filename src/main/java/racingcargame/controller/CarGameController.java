package racingcargame.controller;

import java.util.List;

import racingcargame.model.RacingCarGame;
import racingcargame.view.InputView;
import racingcargame.view.OutputView;

public class CarGameController {
    private static final CarGameController GAME_CONTROLLER = new CarGameController();
    private static final InputView INPUT_CONTROLLER = InputView.getInputController();
    private static final String CAR_NAME_DELIMITER = ",";

    private CarGameController() {
    }

    public static CarGameController getGameController() {
        return GAME_CONTROLLER;
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
        List<String> carNames = makeSplitCarNames(INPUT_CONTROLLER.inputCarName());

        OutputView.showRaceCountInputGuideMessage();
        int raceCount = makeIntegerRaceCount(INPUT_CONTROLLER.inputRaceCount());

        return new RacingCarGame(carNames, raceCount);
    }

    private List<String> makeSplitCarNames(String carNames) {
        return List.of(carNames.split(CAR_NAME_DELIMITER));
    }

    private int makeIntegerRaceCount(String count) {
        return Integer.parseInt(count);
    }
}
