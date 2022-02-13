package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Count;
import racingcar.domain.RandomMovingPolicy;
import racingcar.view.InputView;
import racingcar.view.OutPutView;

public class RacingCarController {

    public void run() {
        Cars cars = getCars();
        race(cars, getCount());

        OutPutView.printResult(cars.getWinners());
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
        while (count.hasNextCount()) {
            cars.move();
            OutPutView.printStatus(cars.getCars());
        }
    }
}
