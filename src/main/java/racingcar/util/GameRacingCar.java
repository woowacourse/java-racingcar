package racingcar.util;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.CarNameFactory;
import racingcar.domain.CarFactory;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameRacingCar {

    private final static String WINNER_DELIMITER = ", ";

    public static void start() {
        CarNameFactory carNameFactory = inputCarNames();
        CarFactory carFactory = new CarFactory(carNameFactory);
        int tryCount = inputTryCount();

        StringBuilder racingProgress = Racing.run(carFactory, tryCount);
        OutputView.printExecutionResult();
        OutputView.printString(racingProgress.toString());

        String winner = Winner.getWinnerWithDelimiter(carFactory, WINNER_DELIMITER);
        OutputView.printWinner(winner);
    }

    private static CarNameFactory inputCarNames() {
        while (true) {
            try {
                OutputView.printInputCarNames();
                String carName = InputView.input();
                CarNameFactory carNameFactory = new CarNameFactory(carName);
                return carNameFactory;
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
