package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.InputController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputController inputController = new InputController(inputView, outputView);
        GameController gameController = new GameController(inputController, outputView);
        gameController.run();
    }
}
