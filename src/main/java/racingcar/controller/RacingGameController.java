package racingcar.controller;

import java.util.List;

import racingcar.domain.RacingGame;
import racingcar.util.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private static RacingGame racingGame;

    public static void setCarsName() {
        String carNamesInput = InputView.inputCarNames();
        List<String> names = Parser.split(carNamesInput);
        racingGame = new RacingGame(names);
    }

    public static void proceedRacingGame() {
        int rounds = InputView.inputRounds();

        OutputView.printRaceResultMessage();
        for (int i = 0; i < rounds; i++) {
            racingGame.moveCars();
            updateViewAfterOneTurn();
        }
    }

    public static void updateViewAfterOneTurn() {
        OutputView.printOneTurnRaceResult(racingGame);
    }

    public static void updateViewChampionNames() {
        OutputView.printChampionNames(racingGame.getChampionNames());
    }

    public static void main(String[] args) {
        setCarsName();
        proceedRacingGame();
        updateViewChampionNames();
    }
}
