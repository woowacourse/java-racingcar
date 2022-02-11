package racingcar;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        String[] names = Parser.split(carNames);

        RacingGame racingGame = new RacingGame(names);
        String rounds = InputView.inputRounds();
        Parser.isValidRounds(rounds);

        System.out.println(OutputView.RACE_RESULT_MESSAGE);
        for (int i = 0; i < Integer.parseInt(rounds); i++) {
            racingGame.moveCars();
            OutputView.printRaceResult(racingGame);
        }

        OutputView.printChampionList(racingGame);
    }
}
