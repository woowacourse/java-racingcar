package racingcar;

import racingcar.domain.Cars;
import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.vo.Trial;
import dto.Winners;

public class RacingGame {
    private final Input input;
    private final Output output;

    public RacingGame(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        Cars cars = new Cars(InputNameHandler.inputToNames(input.inputCarNames()));
        Trial trial = Trial.create(input.inputTrials());
        output.printWinner(race(cars, trial.getCount()));
    }

    public Winners race(Cars cars, int trials) {
        for (int round = 0; round < trials; round++) {
            cars.move();
            output.printCurrentPosition(cars.getCars());
        }
        return cars.getWinners();
    }
}
