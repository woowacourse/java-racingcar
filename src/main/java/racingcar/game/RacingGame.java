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

    private static final int ZERO = 0;
    private static final int FIRST_INDEX = 0;

    private List<Car> carList = new ArrayList<>();
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

    private List<String> getWinners() {
        List<String> winnerNameList = new ArrayList<>();

        int maxPosition = getMaxPosition();

        for (int i = ZERO; i < carList.size(); i++) {
            Car car = carList.get(i);
            getWinnerNameList(winnerNameList, maxPosition, car);
        }

        return winnerNameList;
    }

    private int getMaxPosition() {
        Collections.sort(carList, (o1, o2) -> o2.getPosition() - o1.getPosition());

        int maxPosition = carList.get(FIRST_INDEX).getPosition();

        return maxPosition;
    }

    private void getWinnerNameList(List<String> winnerNameList, int maxPosition, Car car) {
        if (car.isSamePosition(maxPosition)) {
            String winnerName = car.getName();
            winnerNameList.add(winnerName);
        }
    }
}
