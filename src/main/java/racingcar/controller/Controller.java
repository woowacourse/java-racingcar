package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;

public class Controller {

    private final InputView inputView;

    public Controller(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        Cars cars = inputView.askCarNames();
    }
}
