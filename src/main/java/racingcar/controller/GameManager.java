package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.domain.Cars.makeNewCars;

public class GameManager {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void run() {
        List<String> carNames = inputView.getCarName();
        Cars cars = makeNewCars(carNames);
        int tryCount = inputView.getTryCount();
        outputView.printTryResultMenu();
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
            outputView.printTryResult(cars);
        }
        outputView.printWinners(cars);
    }
}
