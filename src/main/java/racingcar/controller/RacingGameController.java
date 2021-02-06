package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.utils.RandomUtils;
import racingcar.view.OutputView;

public class RacingGameController {

    private int maxDistance;

    public void play(final Cars cars, final int attemptNumber) {
        OutputView.printPlayResultMessage();
        for (int i = 0; i < attemptNumber; i++) {
            race(cars);
        }
        OutputView.printWinners(cars.getWinners(maxDistance));
    }

    public void race(final Cars cars) {
        for (Car car : cars.getCars()) {
            maxDistance = Math.max(car.move(RandomUtils.getRandomNumber()), maxDistance);
            OutputView.printCarInformation(car);
        }
        OutputView.printNewLine();
    }

}

