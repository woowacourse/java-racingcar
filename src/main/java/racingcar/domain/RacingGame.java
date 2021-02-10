package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Names;
import racingcar.domain.Trial;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private boolean running = true;

    public void start() {
        try {
            Names names = InputView.getNames();
            Trial trial = InputView.getTrial();
            Cars cars = new Cars(names);

            run(cars, trial);
            OutputView.showResult(cars.getWinners());
            running = false;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    private void run(Cars cars, Trial trial) {
        OutputView.printResultTitle();
        while (trial.decrement()) {
            cars.moveCars();
            OutputView.printCurrentResult(cars.getCurrentPosition());
        }
    }

    public boolean isRunning() {
        return running;
    }
}
