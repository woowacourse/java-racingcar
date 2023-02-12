package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.domain.GameManager;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController(
                new InputView(),
                new OutputView(),
                new RandomNumberGenerator()
        );
        racingCarController.newCarNames();
        racingCarController.newGameRound();
        racingCarController.play();
    }
}
