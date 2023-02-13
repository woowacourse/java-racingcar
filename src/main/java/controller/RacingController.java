package controller;

import domain.Car;
import domain.Cars;
import util.NumberGenerator;
import util.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class RacingController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Cars cars = new Cars();
    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

    private static final int START_INDEX = 0;

    public void play() {
        inputCars();
        moveByTryCount(inputTryCount());
        winners();
    }

    public void inputCars() {
        String[] carNames = inputCarNames();
        for (String carName : carNames) {
            cars.addCar(new Car(carName));
        }
    }

    private void moveByTryCount(int tryCount) {
        outputView.newLine();
        outputView.resultMessage();
        for (int index = START_INDEX; index < tryCount; index++) {
            move();
            printStatus();
        }
    }

    private void move() {
        cars.moveAll(numberGenerator);
    }

    private void winners() {
        outputView.printWinners(cars.pickWinners());
    }

    private void printStatus() {
        outputView.printStatus(cars);
        outputView.newLine();
    }

    private String[] inputCarNames() {
        try {
            outputView.printStartMessage();
            return inputView.inputCarName();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCarNames();
        }
    }

    private int inputTryCount() {
        outputView.printCountMessage();
        return inputView.inputCount();
    }

}
