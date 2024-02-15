package racingcar;

import racingcar.controller.RacingController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RacingController racingController = new RacingController(inputView, outputView);
        racingController.run();
    }
}
