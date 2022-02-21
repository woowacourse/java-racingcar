package racingCar;

import racingCar.controller.GameController;
import racingCar.view.InputView;

public class Application {
    public static void main(String[] args) {
        GameController controller = new GameController(InputView.getInitDto());
        controller.run();
    }
}