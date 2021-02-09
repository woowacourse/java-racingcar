package racingcar;

import racingcar.controller.RacingGameController;

public class Application {

    public static void main(String[] args) {
        final RacingGameController racingGameController = new RacingGameController();
        racingGameController.play();
    }
}
