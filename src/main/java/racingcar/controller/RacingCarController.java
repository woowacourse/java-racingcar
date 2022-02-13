package racingcar.controller;

import racingcar.domain.CarStatus;
import racingcar.domain.Cars;
import racingcar.domain.Count;
import racingcar.domain.RandomMovingPolicy;
import racingcar.view.InputView;
import racingcar.view.OutPutView;

public class RacingCarController {

    public void run() {
        Cars cars = getCars();
        race(cars, getCount());
    }

    private Cars getCars() {
        try {
            return new Cars(InputView.getCarNames(), new RandomMovingPolicy());
        } catch (IllegalArgumentException e) {
            OutPutView.printErrorMessage(e.getMessage());
            return getCars();
        }
    }

    private Count getCount() {
        try {
            return new Count(InputView.getCount());
        } catch (IllegalArgumentException e) {
            OutPutView.printErrorMessage(e.getMessage());
            return getCount();
        }
    }

    private void race(Cars cars, Count count) {
        OutPutView.printStatusMessage();
        proceed(cars, count);
    }

    private void proceed(Cars cars, Count count) {
        try {
            count.subtract();
        } catch (IllegalStateException e) {
            OutPutView.printResult(cars.getWinners());
            return;
        }

        cars.move();
        OutPutView.printStatus(new CarStatus(cars.getCars()).makeCarsStatus());
        proceed(cars, count);
    }
}
