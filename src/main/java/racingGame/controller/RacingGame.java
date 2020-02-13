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
        int movementNumber = InputView.getMovementNumber();
        Cars cars = new Cars(CarFactory.createByNames(InputView.getCarName()));

        for (int i = 0; i < movementNumber; i++) {
            cars.moveCars();
            OutputView.printCars(cars);
        }
        OutputView.printWinners(cars.getWinnersList());
    }


}
