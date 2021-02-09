package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.utils.RandomUtils;
import racingcar.view.OutputView;

public class RacingGameController {

    public void play(final Cars cars, final int attemptNumber) {
        OutputView.printPlayResultMessage();
        for (int i = 0; i < attemptNumber; i++) {
            totalCarMove(cars);
        }
        OutputView.printWinners(cars.getWinners());
    }

    public void totalCarMove(final Cars cars) {
        for (Car car : cars.getCars()) {
            car.move(RandomUtils.getRandomNumber());
            OutputView.printCarInformation(car);
        }
        OutputView.printNewLine();
    }

}

