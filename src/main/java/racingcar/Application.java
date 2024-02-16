package racingcar;

import racingcar.manager.RacingManager;

public class Application {
    public static void main(String[] args) {
        RacingManager manager = new RacingManager();
        manager.racingController().start();
    }
}
