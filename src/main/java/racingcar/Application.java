package racingcar;

import controller.RacingGameController;

public class Application {

    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController();
        racingGameController.race();
    }
}
