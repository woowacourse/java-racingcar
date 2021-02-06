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

        OutputView.printStartRace();

        racing(cars, lap);

        OutputView.printWinners(Winners.toList(cars.getCars()));
    }

    private void racing(Cars cars, Lap lap) {
        while (!lap.isFinish()) {
            passOneLap(cars, lap);
        }
    }

    private void passOneLap(Cars cars, Lap lap) {
        for (Car car : cars.getCars()) {
            car.forward();
            OutputView.printCarInfo(car.getName(), car.getPosition());
        }
        lap.passOneLap();
        OutputView.printPassOneLap();
    }

}

