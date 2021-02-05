package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Names;
import racingcar.domain.Trial;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private static boolean running = true;

    private RacingController() {
    }

    public static void start() {
        try {
            Names names = InputView.getNames();
            Trial trial = InputView.getTrial();
            Cars cars = new Cars(names);

            run(cars, trial);
            OutputView.showResult(cars.getWinners(cars.getMaxPositionCar()));
            running = false;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    private static void run(Cars cars, Trial trial) {
        OutputView.printResultTitle();
        for (int i = 0; i < trial.getTrial(); i++) {
            cars.moveCars();
            OutputView.printCurrentResult(cars.getCurrentPosition());
        }
    }

    public static boolean isRunning() {
        return running;
    }
}
