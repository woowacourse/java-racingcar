package controller;

import model.Cars;
import view.InputView;
import view.MessageView;
import view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final MessageView messageView = new MessageView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Cars cars = setCars();
        repeatMoving(cars, setTryCount());
        outputView.printWinner(cars);
    }

    private Cars setCars() {
        messageView.printCarNameMessage();
        return new Cars(inputView.inputCarName());
    }

    private int setTryCount() {
        messageView.printTryCountMessage();
        return inputView.inputTryCount();
    }

    private void repeatMoving(Cars cars, int tryCount) {
        messageView.printResultMessage();

        for (int count = 0; count < tryCount; count++) {
            cars.moveResult();
            outputView.printResult(cars);
        }
    }
}
