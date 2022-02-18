package racingcar;

import racingcar.domain.RacingGame;

import java.util.List;

import static racingcar.view.InputView.inputAttemptCount;
import static racingcar.view.InputView.inputCarNames;
import static racingcar.view.OutputView.*;

public class Application {
    static RacingGame racingGame = new RacingGame();

    public static void main(String[] args) {
        try {
            init();
            playAndPrintTotalExecutionResult();
            selectAndPrintWinner();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
        }
    }

    private static void init() {
        racingGame.initCarNames(inputCarNames());
        racingGame.initTotalAttempt(inputAttemptCount());
    }

    private static void playAndPrintTotalExecutionResult() {
        racingGame.play();
        printTotalExecutionResult(racingGame.getTotalExecutionResult());
    }

    private static void selectAndPrintWinner() {
        List<String> nameOfWinners = racingGame.selectWinners();
        printWinners(nameOfWinners);
    }

}
