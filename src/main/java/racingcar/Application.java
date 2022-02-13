package racingcar;

import java.util.List;

import racingcar.game.RacingGame;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

public class Application {
    static RacingGame racingGame = new RacingGame();

    public static void main(String[] args) {
        try {
            init();
            playAndPrintExecutionResult();
            selectAndPrintWinner();
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

    private static void selectAndPrintWinner() {
        List<String> nameOfWinners = racingGame.selectWinners();
        printWinners(nameOfWinners);
    }

}
