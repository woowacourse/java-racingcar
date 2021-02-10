package racingcar.controller;

import racingcar.domain.Lap;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {

    public void playGame() {
        Cars cars = Cars.enrollCarsWithNames(InputView.inputCarNames());
        Lap lap = Lap.initGoalLap(InputView.inputLap());
        OutputView.printStartRace();
        OutputView.printWinners(racing(cars, lap).findWinners());
    }

    private Cars racing(Cars cars, Lap lap) {
        while (!lap.isFinish()) {
            cars = cars.passOneLap();
            lap = lap.passOneLap();
            printCarInfo(cars);
            OutputView.printPassOneLap();
        }
        return cars;
    }

    private void printCarInfo(Cars cars) {
        for (Car car : cars.getCars()) {
            OutputView.printCarInfo(car.getName(), car.getPosition());
        }
    }

}

