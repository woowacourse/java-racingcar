package racingcar;

import racingcar.controller.Controller;
import racingcar.view.OutputView;

public class Application {
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        try {
            Controller controller = new Controller();
            controller.startRacing();
            controller.endRacing();
        } catch (Exception error) {
            outputView.printError(error);
        }
    }
}
