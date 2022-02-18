package racingcar;

import racingcar.controller.MainController;

public class Application {
    public static void main(final String... args) {
        MainController mainController = new MainController();
        mainController.play();
    }
}
