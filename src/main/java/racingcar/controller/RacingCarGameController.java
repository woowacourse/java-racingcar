package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {
    public void playGame() {
        Cars cars = new Cars(InputView.inputCarNames());
        Lap lap = new Lap(InputView.inputLap());

        race(cars, lap);
        OutputView.printWinners(Winners.makeWinners(cars.getCars()));
    }

    private void race(Cars cars, Lap lap) {
        OutputView.printOneLine();
        OutputView.printStartRace();
        while (!lap.isFinishAll()) {
            raceOneLap(cars);
            OutputView.printOneLine();
            lap.finishOneLap();
        }
    }

    private void raceOneLap(Cars cars) {
        for (Car car : cars.getCars()) {
            car.moveByRandomNumber(RandomNumber.make());
            OutputView.printCarInfo(car.getName(), car.getPosition());
        }
    }
}

