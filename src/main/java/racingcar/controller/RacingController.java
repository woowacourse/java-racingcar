package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Names;
import racingcar.domain.Trial;
import racingcar.utils.RandomUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private boolean running = true;

    public void start() {
        try {
            OutputView.enterCarNames();
            Names names = InputView.getNames();
            Cars cars = new Cars(names);

            OutputView.enterTrials();
            Trial trial = InputView.getTrial();

            OutputView.printResultTitle();

            runTrial(cars, trial);

            List<Car> winnerCars = cars.getWinnerCars(cars.getMaxPositionCar());
            OutputView.printWinnerTitle();
            OutputView.printWinners(winnerCars);
            running = false;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    private void runTrial(Cars cars, Trial trial) {
        for (int i = 0; i < trial.getTrial(); i++) {
            goEachCar(cars);
            OutputView.printCurrentResult(cars.getCurrentPosition());
        }
    }

    private void goEachCar(Cars cars) {
        for (Car car : cars.getCars()) {
            car.movePosition(RandomUtils.generateRandomValue());
        }
    }

    public boolean isRunning() {
        return running;
    }
}
