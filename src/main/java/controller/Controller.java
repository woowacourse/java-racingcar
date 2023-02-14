package controller;

import domain.Cars;
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
        Cars cars = initCarData();
        movePerRounds(cars, setTryCount());
        outputView.printWinner(cars.getWinners());
    }

    private Cars initCarData() {
        messageView.printCarNameMessage();

        try {
            String carNames = inputView.inputCarNames();
            validation.validateCarNames(carNames);
            return new Cars(carNames);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return initCarData();
        }
    }

    private void movePerRounds(Cars cars, int tryCount) {
        messageView.printResultMessage();

        for (int count = 0; count < tryCount; count++) {
            cars.moveForRound(randomNumberGenerator);
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
