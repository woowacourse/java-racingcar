package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    public Cars initCars(String[] carNames) {
        return new Cars(carNames);
    }

    public void runGame() {
        try {
            startGame();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void startGame() throws RuntimeException {
        InputController inputController = new InputController();

        String[] carNames = inputController.getUserCarNames(InputView.scanCarNames());
        int tryCount = inputController.getUserTryCount(InputView.scanTryCount());
        Cars cars = initCars(carNames);
        OutputView.printResultPrefix();
        for (int i = 0; i < tryCount; i++) {
            cars.moveRound();
            printPosition(cars);
        }
        printWinner(cars);
    }

    public void printPosition(Cars cars) {
        OutputView.printResult(cars.getRacingCars());
    }

    public void printWinner(Cars cars) {
        OutputView.printWinner(cars.getWinner());
    }
}
