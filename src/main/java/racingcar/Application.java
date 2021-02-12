package racingcar;

import racingcar.controller.RacingCarGameController;
import racingcar.domain.RacingCarGame;
import racingcar.view.RacingCarGameView;

public class Application {
    public static void main(String[] args) {
        RacingCarGameController racingCarGameController = new RacingCarGameController(new RacingCarGame(), new RacingCarGameView());
        racingCarGameController.run();
    }
}
