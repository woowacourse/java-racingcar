package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.util.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private static RacingGame racingGame;

    public static void setRacingGame() {
        racingGame = new RacingGame(InputView.inputCarNames(), InputView.inputRounds());
    }

    public static void proceedRacingGame() {
        OutputView.printRaceResultMessage();
        while (!racingGame.isFinished()) {
            racingGame.moveCars();
            updateViewOneTurnResult();
        }
    }

    public static void updateViewOneTurnResult() {
        OutputView.printOneTurnRaceResult(racingGame.getCars());
    }

    public static void updateViewChampionNames() {
        OutputView.printChampionNames(racingGame.getChampionNames());
    }

    public static void main(String[] args) {
        setRacingGame();
        proceedRacingGame();
        updateViewChampionNames();
    }
}
