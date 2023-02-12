package racingcar;

import racingcar.domain.Cars;
import racingcar.controller.RacingGameController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {

    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController(
                new InputView(),
                new OutputView(),
                new Cars());

        racingGameController.playGame();
    }
}
