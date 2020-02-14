package racingcar.util;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.CarNameFactory;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameRacingCar {

    private final static String WINNER_DELIMITER = ", ";

    public static void start() {
        List<CarName> carNames = inputCarNames();
        List<Car> cars = new Cars(carNames).getCars();
        int tryCount = inputTryCount();

        StringBuilder racingProgress = Racing.run(cars, tryCount);
        OutputView.printExecutionResult();
        OutputView.printString(racingProgress.toString());

        String winner = Winner.getWinnerWithDelimiter(cars, WINNER_DELIMITER);
        OutputView.printWinner(winner);
    }

    private static List<CarName> inputCarNames() {
        while (true) {
            try {
                OutputView.printInputCarNames();
                String carName = InputView.input();
                CarNameFactory carNameFactory = new CarNameFactory(carName);
                return carNameFactory.getCarNames();
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
