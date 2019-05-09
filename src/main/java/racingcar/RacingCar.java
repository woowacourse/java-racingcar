package racingcar;

import racingcar.controller.Controller;
import racingcar.view.View;

public class RacingCar {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.run(View.inputNameOfCar(), View.inputNumberOfTry());
    }
}
