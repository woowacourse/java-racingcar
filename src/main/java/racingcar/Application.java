package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.InputController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;

public class Application {

    private static InputView createInputView() {
        return new InputView(new Scanner(System.in), new OutputView());
    }

    private static OutputView createOutputView() {
        return new OutputView();
    }

    private static InputController createInputController() {
        return new InputController();
    }

    public static void main(String[] args) {
        GameController gameController = new GameController(createInputController(), createInputView(), createOutputView());
        gameController.run();
    }
}
