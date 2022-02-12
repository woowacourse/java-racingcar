package racingcar;

import racingcar.game.RacingGame;

import java.util.List;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

public class Application {
    static RacingGame racingGame = new RacingGame();

    public static void main(String[] args) {
        try {
            init();
            playAndPrintExecutionResult();
            selectAndPrintWinners();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
        }
    }

    private static void init() {
        racingGame.initCarNames(inputCarNames());
        racingGame.initTotalAttempt(inputAttemptCount());
    }

    private static void playAndPrintExecutionResult() {
        String executionResult = racingGame.play();
        printExecutionResult(executionResult);
    }

    private static void selectAndPrintWinners() {
        List<String> nameOfWinners = racingGame.selectWinners();
        printWinners(nameOfWinners);
    }
}
