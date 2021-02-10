package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private boolean running = true;

    public void run() {
        try {
            Names names = InputView.getNames();
            Trial trial = InputView.getTrial();
            Cars cars = new Cars(names);

            race(cars, trial);
            OutputView.showResult(cars.getWinners());
            running = false;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
        }
    }

    private void race(Cars cars, Trial trial) {
        OutputView.printResultTitle();
        while (trial.decrement()) {
            cars.moveCars();
            OutputView.printCurrentResult(cars.getCurrentCarsInfo());
        }
    }

    public boolean isRunning() {
        return running;
    }
}
