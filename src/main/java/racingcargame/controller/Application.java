package racingcargame.controller;

import racingcargame.view.InputView;
import racingcargame.view.OutputView;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(new InputView(), new OutputView());
        gameController.runGame();
    }
}
