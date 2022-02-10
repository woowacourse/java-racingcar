package racingcar;

import racingcar.io.Input;
import racingcar.io.Output;

public class RacingCarApplication {
    public static void main(String[] args) {
        new RacingGame(new Input(), new Output()).start();
    }
}
