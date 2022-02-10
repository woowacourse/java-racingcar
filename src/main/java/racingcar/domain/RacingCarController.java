package racingcar.domain;

import racingcar.view.InputView;
import racingcar.view.OutPutView;

public class RacingCarController {

    public void run() {
        Cars cars = new Cars(InputView.getCarNames(), new RandomMovingPolicy());
        race(cars, getCount());

        OutPutView.printResult(cars.getWinners());
    }

    private Count getCount() {
        return InputView.getCount();
    }

    private void race(Cars cars, Count count) {
        OutPutView.printStatusMessage();
        while (count.isPositive()) {
            count.subtract();
            cars.move();
            OutPutView.printStatus(cars.getCars());
        }
    }
}
