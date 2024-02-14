package racingcar.controller;

import racingcar.view.InputView;

public class GameController {

    private final InputView inputView;

    public GameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String names = inputView.readCarNames();

    }

}
