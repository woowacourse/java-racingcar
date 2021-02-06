package racingcar.controller;

import racingcar.domain.Lap;
import racingcar.domain.Winners;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {
    public void playGame() {
        Cars cars = new Cars(InputView.inputCarNames());
        Lap lap = new Lap(InputView.inputLap());

        race(cars, lap);
        OutputView.printWinners(Winners.award(cars.getCars()));
    }

    private void race(Cars cars, Lap lap) {
        OutputView.printOneLine();
        OutputView.printStartRace();
        while (!lap.isFinish()) {
            raceOneLap(cars);
            OutputView.printOneLine();
            lap.passOneLap();
        }
    }

    private void raceOneLap(Cars cars) {
        for (Car car : cars.getCars()) {
            car.forward();
            OutputView.printCarInfo(car.getName(), car.getPosition());
        }
    }
}

