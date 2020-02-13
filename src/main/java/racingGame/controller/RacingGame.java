package racingGame.controller;

import java.util.ArrayList;
import java.util.List;

import racingGame.domain.Car;
import racingGame.domain.Cars;
import racingGame.utils.CarFactory;
import racingGame.view.InputView;
import racingGame.view.OutputView;

public class RacingGame {
    public void run() {
        Cars cars = new Cars(CarFactory.createByNames(InputView.getCarName()));
        int movementNumber = InputView.getMovementNumber();

        for (int i = 0; i < movementNumber; i++) {
            cars.moveCars();
            OutputView.printCars(cars);
        }
        OutputView.printWinners(cars.getWinnersList());
    }
}
