package racingcar;

import racingcar.controller.MainController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        final MainController mainController = new MainController();
        mainController.run();
    }
}
