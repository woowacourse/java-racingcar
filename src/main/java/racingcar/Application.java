package racingcar;

import racingcar.controller.CarController;
import racingcar.view.ConsoleInputView;
import racingcar.view.InputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        CarController controller = new CarController(inputView);
        controller.run();
    }
}
