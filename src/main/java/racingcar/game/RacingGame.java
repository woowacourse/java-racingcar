package racingcar.game;

import racingcar.entity.Car;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static racingcar.view.InputView.getAttemptCount;
import static racingcar.view.InputView.getCarNames;
import static racingcar.view.OutputView.*;

public class RacingGame {

    private List<Car> carList = new ArrayList<>();
    private List<String> winners = new ArrayList<>();
    private int totalAttemptCount;

    public void start() {
        initRacingCarGame();

        startMessage();
        while (totalAttemptCount --> 0) {
            run();
        }

        getWinners();

        printWinners(winners);
    }

    private void initRacingCarGame() {
        String[] names = getCarNames().split(",");

        for (String name : names) {
            carList.add(new Car(name));
        }

        totalAttemptCount = Integer.parseInt(getAttemptCount());
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

        int maxPosition = carList.get(0).getPosition();

        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            isWinner(car, maxPosition);
        }
    }
    private void isWinner(Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }
    }
}
