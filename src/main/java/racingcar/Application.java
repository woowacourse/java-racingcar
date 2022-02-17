package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.OutputView.ConsoleOutputView;


public class Application {
    public static void main(String[] args) {
        RacingController racingController =
                new RacingController(new ConsoleOutputView());
        racingController.run();
    }
}
