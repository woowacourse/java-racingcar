package racingcar;

import racingcar.controller.InputManager;
import racingcar.controller.RacingCarManager;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        RacingCarManager racingStart = new RacingCarManager();

        racingStart.racingGameStart(inputManager);
    }
}
