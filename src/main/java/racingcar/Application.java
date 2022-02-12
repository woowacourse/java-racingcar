package racingcar;

import racingcar.game.RacingGame;

import java.util.List;

import static racingcar.view.InputView.*;
import static racingcar.view.OutputView.*;

public class Application {
    static RacingGame racingGame = new RacingGame();

    public static void main(String[] args) {
        try {
            play();
            selectAndPrintWinners();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
        }
    }

    private static void play() {
        String executionResult = racingGame.play(inputCarNames(), inputAttemptCount());
        printExecutionResult(executionResult);
    }

    private static void selectAndPrintWinners() {
        List<String> nameOfWinners = racingGame.selectWinners();
        printWinners(nameOfWinners);
    }
}
