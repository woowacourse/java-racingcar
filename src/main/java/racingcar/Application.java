package racingcar;

import racingcar.domain.RacingGame;

import java.util.List;

import static racingcar.view.InputView.inputAttemptCount;
import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.OutputView.*;

public class Application {
    private static RacingGame racingGame;

    public static void main(String[] args) {
        try {
            racingGame = new RacingGame(inputCarNames(), inputAttemptCount());
            playAndPrintTotalExecutionResult();
            selectAndPrintWinner();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
        }
    }

    private static void playAndPrintTotalExecutionResult() {
        printTotalExecutionResult(racingGame.play());
    }

    private static void selectAndPrintWinner() {
        List<String> nameOfWinners = racingGame.selectWinners();
        printWinners(nameOfWinners);
    }

}
