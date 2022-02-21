package racingCar;

import racingCar.controller.GameController;
import racingCar.view.InputView;
import racingCar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        GameController controller = new GameController(new InputView());
        controller.run(new OutputView());
    }
}