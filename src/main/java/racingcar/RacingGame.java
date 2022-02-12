package racingcar;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import racingcar.domain.Cars;
import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.util.RandomUtil;
import racingcar.vo.Number;
import racingcar.vo.Trial;
import racingcar.dto.Winners;

public class RacingGame {
    private static final int RANDOM_NUMBER_RANGE = 9 + 1;

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

    private Winners race(Cars cars, int trials) {
        for (int round = 0; round < trials; round++) {
            cars.move(createNumbers(cars.size()));
            output.printCurrentPosition(cars.getCars());
        }
        return cars.getWinners();
    }

    private Queue<Number> createNumbers(int size) {
        return RandomUtil.getRandomNumbers(size, RANDOM_NUMBER_RANGE).stream()
            .map(Number::create)
            .collect(Collectors.toCollection(LinkedList::new));
    }
}
