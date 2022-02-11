package racingcar.game;

import racingcar.entity.Car;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static racingcar.util.InitUtil.initCar;
import static racingcar.util.InitUtil.initTotalAttempt;
import static racingcar.view.OutputView.*;

public class RacingGame {

    public static final int ZERO = 0;
    public static final int FIRST_INDEX = 0;

    private List<Car> carList = new ArrayList<>();
    private List<String> winnerNameList = new ArrayList<>();
    private int totalAttemptCount;

    public void start() throws IllegalArgumentException {
        initRacingCarGame();
        startMessage();

        while (totalAttemptCount --> ZERO) {
            run();
        }

        getWinners();
        printWinners(winnerNameList);
    }

    private void initRacingCarGame() throws IllegalArgumentException {
        carList = initCar();
        totalAttemptCount = initTotalAttempt();
    }

    private void run() {
        for (Car car : carList) {
            car.progress();
        }
        printProgress();
        printLine();
    }

    private void printProgress() {
        for (Car car : carList) {
            String carName = car.getName();
            int position = car.getPosition();

            OutputView.printProgress(carName, position);
        }
    }

    private void getWinners() {
        Collections.sort(carList);

        int maxPosition = carList.get(FIRST_INDEX).getPosition();

        for (int i = ZERO; i < carList.size(); i++) {
            Car car = carList.get(i);
            addWinnerName(maxPosition, car);
        }
    }

    private void addWinnerName(int maxPosition, Car car) {
        if (car.isWinner(maxPosition)) {
            winnerNameList.add(car.getName());
        }
    }
}
