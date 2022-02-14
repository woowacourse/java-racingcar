package racingcar;

import java.util.List;

import racingcar.domain.CarDTO;
import racingcar.game.RacingGame;

import static racingcar.view.InputView.*;
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
        List<List<CarDTO>> executionResult = racingGame.play();
        printTotalExecutionResult(executionResult);
    }

    private static void selectAndPrintWinner() {
        List<String> nameOfWinners = racingGame.selectWinners();
        printWinners(nameOfWinners);
    }

}
