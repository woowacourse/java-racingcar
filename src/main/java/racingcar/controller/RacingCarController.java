package racingcar.controller;

import racingcar.domain.CarsStatus;
import racingcar.domain.Cars;
import racingcar.domain.Count;
import racingcar.domain.RandomMovingPolicy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = getCars();
        race(cars, getCount());
    }

    private Cars getCars() {
        try {
            return new Cars(inputView.getCarNames(), new RandomMovingPolicy());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getCars();
        }
    }

    private Count getCount() {
        try {
            return new Count(inputView.getCount());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return getCount();
        }
    }

    private void race(Cars cars, Count count) {
        outputView.printStatusMessage();
        proceed(cars, count);
    }

    private void proceed(Cars cars, Count count) {
        try {
            count.subtract();
        } catch (IllegalStateException e) {
            outputView.printResult(cars.getWinners());
            return;
        }

        cars.move();
        outputView.printStatus(new CarsStatus(cars.getCars()).makeCarsStatus());
        proceed(cars, count);
    }
}
