package racingcar;

import racingcar.controller.GameController;
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

    public static void main(String[] args) {
        GameController gameController = new GameController(createInputView(), createOutputView());
        gameController.run();
    }
}
