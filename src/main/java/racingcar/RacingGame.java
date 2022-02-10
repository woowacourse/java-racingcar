package racingcar;

public class RacingGame implements Runnable {
    private final Input input;

    public RacingGame(Input input) {
        this.input = input;
    }

    @Override
    public void run() {
        Cars cars = new Cars(InputNameHandler.createNames(input.inputCarNames()));
        int trials = input.inputTrials();
        for (int round = 0; round < trials; round++) {
            cars.move();
        }
    }

}
