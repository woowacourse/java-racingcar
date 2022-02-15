package racingcargame.controller;

import racingcargame.model.RacingCarGame;
import racingcargame.view.InputView;
import racingcargame.view.OutputView;

import java.util.List;

public class CarGameController {
    private final CarGameController gameController;
    private static final String CAR_NAME_DELIMITER = ",";

    public CarGameController() {
        this.gameController = new CarGameController();
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
        List<String> carNames = makeSplitCarNames(InputView.inputCarName());

        OutputView.showRaceCountInputGuideMessage();
        int raceCount = makeIntegerRaceCount(InputView.inputRaceCount());

        return new RacingCarGame(carNames, raceCount);
    }

    private List<String> makeSplitCarNames(String carNames) {
        return List.of(carNames.split(CAR_NAME_DELIMITER));
    }

    private int makeIntegerRaceCount(String count) {
        return Integer.parseInt(count);
    }
}
