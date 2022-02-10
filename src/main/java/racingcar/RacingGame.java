package racingcar;

import java.util.List;

public class RacingGame implements Runnable {
    private final Input input;
    private final Output output;

    public RacingGame(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        Cars cars = new Cars(InputNameHandler.createNames(input.inputCarNames()));
        int trials = input.inputTrials();
        for (int round = 0; round < trials; round++) {
            cars.move();
            output.printCurrentPosition(cars.getCars());
        }
        output.printWinner(cars.getWinner());
    }

}
