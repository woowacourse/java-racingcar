package racingcar;

import racingcar.controller.Controller;
import racingcar.exception.ExceptionHandler;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(
                new InputView(),
                new ResultView(),
                new ExceptionHandler()
        );
        controller.run();
    }
}
