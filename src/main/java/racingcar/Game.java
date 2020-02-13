package racingcar;

import racingcar.domain.Cars;
import racingcar.io.ConsoleOutput;
import racingcar.util.RandomNumberGenerator;

public class Game {

    private final int iteration;

    private Cars cars;

    public Game(Cars cars, int iteration) {
        this.cars = cars;
        this.iteration = iteration;
    }

    public void playGame() {
        RandomNumberGenerator random = new RandomNumberGenerator();
        for (int i = 0; i < iteration; i++) {
            cars.playTurn(random);
            ConsoleOutput.printStatus(cars.notifyStatus());
        }
        ConsoleOutput.printResult(cars.findWinner());
    }
}
