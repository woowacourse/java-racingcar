package racingcar;

import racingcar.controller.RacingcarController;
import racingcar.service.CarService;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        RacingcarController racingcarController = new RacingcarController(new CarService());
        racingcarController.start();
    }
}
