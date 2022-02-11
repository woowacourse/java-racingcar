package racingcar.controller;

import racingcar.model.InputNameHandler;
import racingcar.model.firstcollection.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    public void start() {
        Cars cars = setupCars();
        race(cars, InputView.getTrial());
        OutputView.printWinner(cars.getWinner());
    }

    private Cars setupCars() {
        return new Cars(InputNameHandler.createNames(InputView.getCarNames()));
    }

    private void race(Cars cars, int trials) {
        for (int round = 0; round < trials; round++) {
            cars.move();
            OutputView.printCurrentPosition(cars.getCars());
        }
    }
}
