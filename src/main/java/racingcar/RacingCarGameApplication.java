package racingcar;

import racingcar.controller.GameController;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.run();
    }
}
