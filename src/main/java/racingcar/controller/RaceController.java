package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.OutputView;

public class RaceController {
    private static final int DEFAULT_POSITION = 0;

    private Cars cars;

    public void initCars() {
        cars = new Cars();
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
        String[] carNames = inputController.getUserCarNames();
        int tryCount = inputController.getUserTryCount();
        insertCarFromCarNames(carNames);
        OutputView.printResultPrefix();
        for (int i = 0; i < tryCount; i++) {
            cars.moveRound();
            printPosition();
        }
        printWinner();
    }

    public void insertCarFromCarNames(String[] carNames) {
        initCars();
        for (String carName : carNames) {
            cars.insertCar(new Car(carName, DEFAULT_POSITION));
        }
    }

    public int carCount() {
        return cars.getCars().size();
    }

    public void printPosition() {
        OutputView.printResult(cars.getCars());
    }

    public void printWinner() {
        OutputView.printWinner(cars.getWinner());
    }
}
