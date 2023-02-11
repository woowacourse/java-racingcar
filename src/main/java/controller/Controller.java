package controller;

import model.Cars;
import util.RandomNumberGenerator;
import validation.Validation;
import view.InputView;
import view.MessageView;
import view.OutputView;

public class Controller {
    private final Validation validation = new Validation();
    private final InputView inputView = new InputView();
    private final MessageView messageView = new MessageView();
    private final OutputView outputView = new OutputView();
    private final RandomNumberGenerator randomNumberGenerator
            = new RandomNumberGenerator();

    public void runGame() {
        Cars cars = setCars();
        repeatMoving(cars, setTryCount());
        outputView.printWinner(cars.getWinners());
    }

    private Cars setCars() {
        messageView.printCarNameMessage();

        try {
            String carNames = inputView.inputCarNames();
            validation.validateCarNames(carNames);
            return new Cars(carNames);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return setCars();
        }
    }

    private void repeatMoving(Cars cars, int tryCount) {
        messageView.printResultMessage();

        for (int count = 0; count < tryCount; count++) {
            cars.moveResult(randomNumberGenerator);
            outputView.printResult(cars);
        }
    }

    private int setTryCount() {
        messageView.printTryCountMessage();

        try {
            int tryCount = inputView.inputTryCount();
            validation.validateTryCount(tryCount);
            return tryCount;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return setTryCount();
        }
    }
}
