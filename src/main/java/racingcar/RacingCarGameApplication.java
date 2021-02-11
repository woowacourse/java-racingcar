package racingcar;

import racingcar.controller.GameManagerController;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        GameManagerController gameController = new GameManagerController();
        gameController.run();
    }
}
