package racingcar.domain;

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
            return getCars();
        }
    }

    private Count getCount() {
        try {
            return InputView.getCount();
        } catch (IllegalArgumentException e) {
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
