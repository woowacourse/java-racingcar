package racing;

import racing.domain.RacingGame;
import racing.domain.RacingResult;
import racing.view.InputView;
import racing.view.OutputView;

public class Main {
    public static void main(String[] args) {
        String[] carNames = InputView.inputCarNames();
        int tryNo = InputView.inputExecution();

        RacingGame racingGame = new RacingGame(carNames);
        RacingResult result = null;

        System.out.println(OutputView.PROCESS_RESULT_MESSAGE);
        for (int i = 0; i < tryNo; i++) {
            result = racingGame.race();
            OutputView.printResults(result);
        }
        OutputView.printAllWinners(result);
    }
}
