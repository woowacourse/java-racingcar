package racingcar;

import racingcar.controller.Controller;
import racingcar.exception.ExceptionHandler;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(
                new InputView(), new OutputView(), new ExceptionHandler()
        );
        controller.run();
    }
}
