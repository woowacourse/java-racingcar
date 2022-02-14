package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private Cars cars;

    public void initCars(String[] carNames) {
        cars = new Cars(carNames);
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
        initCars(carNames);
        OutputView.printResultPrefix();
        for (int i = 0; i < tryCount; i++) {
            cars.moveRound();
            printPosition();
        }
        printWinner();
    }

    public void printPosition() {
        OutputView.printResult(cars.getRacingCars());
    }

    public void printWinner() {
        OutputView.printWinner(cars.getWinner());
    }
}
