package racingcar;

import racingcar.controller.MainController;
import racingcar.utils.ErrorUtils;

public class Application {

    public static void main(String args[]) {
        MainController mainController = new MainController();
        mainController.run();
    }
}
