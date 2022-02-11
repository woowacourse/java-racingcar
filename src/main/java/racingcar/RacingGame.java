package racingcar;

import racingcar.domain.Cars;
import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.vo.Trial;

public class RacingGame {
    private final Input input;
    private final Output output;

    public RacingGame(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        Cars cars = new Cars(InputNameHandler.createNames(input.inputCarNames()));
        Trial trial = Trial.create(input.inputTrials());
        output.printWinner(cars.race(trial.getCount()));
    }
}
