package racingcar;

import racingcar.config.RacingConfig;

public class Application {
    public static void main(String[] args) {
        RacingConfig config = new RacingConfig();
        config.racingController().run();
    }
}
