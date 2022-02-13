package racingcar;

import java.util.List;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        String carNamesInput = InputView.inputCarNames();
        List<String> names = Parser.split(carNamesInput);
        RacingGame racingGame = new RacingGame(names);

        String rounds = InputView.inputRounds();

        OutputView.printRaceResultMessage();
        for (int i = 0; i < Integer.parseInt(rounds); i++) {
            racingGame.moveCars();
            OutputView.printOneTurnRaceResult(racingGame);
        }

        OutputView.printChampionList(racingGame);
    }
}
