package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Lap;

import static racingcar.view.OutputView.printCarsStatus;

public class RacingController {
    public void start(Cars cars, Lap lap) {
        run(cars, lap);
    }

    private void run(Cars cars, Lap lap) {
        do {
            cars.moveCars();
            lap.run();
            printCarsStatus(cars.getCars());
        } while (!lap.isNotSame());
    }
}
