package racingcar.game;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.util.InitUtil.initTotalAttempt;
import static racingcar.view.InputView.getAttemptCount;
import static racingcar.view.InputView.getCarNames;
import static racingcar.view.OutputView.*;

public class RacingGame {

    private static final int ZERO = 0;

    private Cars cars;
    private int totalAttemptCount;

    public void start() throws IllegalArgumentException {
        initRacingCarGame();
        startMessage();

        while (totalAttemptCount --> ZERO) {
            run();
        }

        List<String> winnerNameList = getWinners();
        printWinners(winnerNameList);
    }

    private void initRacingCarGame() throws IllegalArgumentException {
        String carNames = getCarNames();
        cars = new Cars(carNames);

        String attempt = getAttemptCount();
        totalAttemptCount = initTotalAttempt(attempt);
    }

    private void run() {
        cars.progressWithAllCar();
        printProgress();
        printLine();
    }

    private void printProgress() {
        for (int i = 0; i < cars.getSize(); i++) {
            Car car = cars.getCar(i);
            String carName = car.getName();
            int position = car.getPosition();

            OutputView.printProgress(carName, position);
        }
    }

    private List<String> getWinners() {
        int maxPosition = cars.getMaxPosition();

        return cars.getWinner(maxPosition);
    }
}
