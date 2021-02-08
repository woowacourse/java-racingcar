package racingcar.controller;

import racingcar.domain.Lap;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.utils.RandomUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {

    private static final int MINIMUM_GAS = 0;
    private static final int MAXIMUM_GAS = 9;

    public void playGame() {
        Cars cars = Cars.enrollCarsWithNames(InputView.inputCarNames());
        Lap lap = Lap.initGoalLap(InputView.inputLap());

        OutputView.printStartRace();
        racing(cars, lap);
        OutputView.printWinners(cars.getWinners());
    }

    private void racing(Cars cars, Lap lap) {
        while (!lap.isFinish()) {
            passOneLap(cars, lap);
        }
    }

    private void passOneLap(Cars cars, Lap lap) {
        for (Car car : cars.getCars()) {
            car.fillUpGas(RandomUtils.nextPositiveInt(MINIMUM_GAS, MAXIMUM_GAS));
            car.forward();
            OutputView.printCarInfo(car.getName(), car.getPosition());
        }
        lap.passOneLap();
        OutputView.printPassOneLap();
    }

}

