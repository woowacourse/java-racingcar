package racingcar.service;

import racingcar.domain.Attempt;
import racingcar.domain.Cars;
import racingcar.view.Input;

public class RacingCarGame {
    private Cars cars;
    private Attempt attempt;

    private final Input input;

    RacingCarGame() {
        input = new Input();
    }
}
