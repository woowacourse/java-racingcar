package racingcar;

import racingcar.controller.GameController;
import racingcar.view.InputView;

public class Application {


    public static void main(String[] args) {

        InputView inputView = new InputView();
        GameController gameController = new GameController(inputView);
        gameController.run();
    }
}
