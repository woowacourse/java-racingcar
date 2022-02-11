package racingcar;

import racingcar.controller.RacingGame;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingCarApplication {
    public static void main(String[] args) {
        new RacingGame(new Input(), new Output()).start();
    }
}
