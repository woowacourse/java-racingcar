package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.domain.Cars.makeNewCars;

public class GameManager {

    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int MINIMUM_MOVEMENT_CONDITION = 4;

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void run() {
        outputView.printCarNameInputMessage();
        List<String> carNames = inputView.getCarName();
        Cars cars = makeNewCars(carNames);
        outputView.printTryCountInputMessage();
        int tryCount = inputView.getTryCount();
        outputView.printTryResultMenu();
        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
            outputView.printTryResult(cars);
        }
        outputView.printWinners(cars);
    }
}
