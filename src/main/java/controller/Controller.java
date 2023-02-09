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

        try {
            Cars cars = new Cars(inputView.inputCarName());
            return cars;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return setCars();
        }
    }

    private int setTryCount() {
        messageView.printTryCountMessage();
        try{
            return inputView.inputTryCount();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return setTryCount();
        }
    }

    private void repeatMoving(Cars cars, int tryCount) {
        messageView.printResultMessage();

        for (int count = 0; count < tryCount; count++) {
            cars.moveResult();
            outputView.printResult(cars);
        }
    }
}
