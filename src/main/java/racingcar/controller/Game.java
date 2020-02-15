package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Times;
import racingcar.domain.Winners;
import racingcar.io.InputView;
import racingcar.io.OutputView;

public class Game {
    public void run() {
        Cars cars = InputView.getCars();
        Times times = InputView.getTimes();
        OutputView.printResultTitle();
        move(cars, times);
        OutputView.printWinners(new Winners(cars.getWinners()));
    }

    public void move(Cars cars, Times times) {
        while (!times.isDone()) {
            cars.move();
            times.reduce();
            OutputView.printCars(cars);
        }
    }
}
