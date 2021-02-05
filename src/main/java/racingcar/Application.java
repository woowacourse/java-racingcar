package racingcar;

import racingcar.controller.RacingController;

public class Application {
    public static void main(String[] args) {
        while (RacingController.isRunning()) {
            RacingController.start();
        }
    }
}
