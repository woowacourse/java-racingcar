package racingcar;

import racingcar.controller.GameController;

public class RacingApplication {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.run();
    }
}
