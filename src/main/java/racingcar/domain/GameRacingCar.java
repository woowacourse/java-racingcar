package racingcar.domain;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameRacingCar {

    public final static String WINNER_DELIMITER = ", ";

    public static void start() {
        List<String> carNames = inputCarNames();
        int tryCount = inputTryCount();
        Racing racing = new Racing(carNames, tryCount);

        String racingProgress = racing.run();
        OutputView.printExecutionResult();
        OutputView.printString(racingProgress);

        String winner = racing.getWinner(WINNER_DELIMITER);
        OutputView.printWinner(winner);
    }

    private static List<String> inputCarNames() {
        while (true) {
            try {
                OutputView.printInputCarNames();
                String carName = InputView.input();
                CarNames carNames = new CarNames(carName);
                return carNames.getCarNames();
            } catch (IllegalArgumentException ioe) {
                OutputView.printString(ioe.getMessage());
            }
        }
    }

    private static int inputTryCount() {
        while (true) {
            try {
                OutputView.printInputTryCount();
                String count = InputView.input();
                TryCount tryCount = new TryCount(count);
                return tryCount.getTryCount();
            } catch (Exception e) {
                OutputView.printString(e.getMessage());
            }
        }
    }
}
