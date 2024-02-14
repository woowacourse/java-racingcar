package racingcar;

import racingcar.controller.Controller;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new InputView());
        controller.run();
    }
}
