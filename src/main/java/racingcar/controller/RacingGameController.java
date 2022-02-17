package racingcar.controller;

import java.util.List;

import racingcar.domain.RacingGame;
import racingcar.util.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    public static void main(String[] args) {
        String carNamesInput = InputView.inputCarNames();
        List<String> names = Parser.split(carNamesInput);
        RacingGame racingGame = new RacingGame(names);

        int rounds = InputView.inputRounds();

        OutputView.printRaceResultMessage();
        for (int i = 0; i < rounds; i++) {
            racingGame.moveCars();
            OutputView.printOneTurnRaceResult(racingGame);
        }

        OutputView.printChampionNames(racingGame.getChampionNames());
    }
}
