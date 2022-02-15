package racingcar.controller;

import racingcar.domain.CarsStatus;
import racingcar.domain.Cars;
import racingcar.domain.Count;
import racingcar.domain.RandomMovingPolicy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;

    public RacingCarController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        Cars cars = getCars();
        race(cars, getCount());
    }

    private Cars getCars() {
        try {
            return new Cars(inputView.getCarNames(), new RandomMovingPolicy());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getCars();
        }
    }

    private Count getCount() {
        try {
            return new Count(inputView.getCount());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getCount();
        }
    }

    private void race(Cars cars, Count count) {
        OutputView.printStatusMessage();
        proceed(cars, count);
    }

    private void proceed(Cars cars, Count count) {
        try {
            count.subtract();
        } catch (IllegalStateException e) {
            OutputView.printResult(cars.getWinners());
            return;
        }

        cars.move();
        OutputView.printStatus(new CarsStatus(cars.getCars()).makeCarsStatus());
        proceed(cars, count);
    }
}
