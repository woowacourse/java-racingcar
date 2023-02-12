package racinggame.domain;

import racinggame.utils.RandomNumberGenerator;
import racinggame.view.Output;

import java.util.List;

public class RacingGame {
    private final CarGenerator carGenerator;
    private final Winner winner;
    private List<Car> cars;
    private int tryCount;

    public RacingGame(String[] carNames, int tryCount) {
        carGenerator = new CarGenerator();
        winner = new Winner();
        cars = carGenerator.generateCars(carNames);
        this.tryCount = tryCount;
    }

    public void run() {
        while (isGameContinue()) {
            cars.forEach(car -> car.move(RandomNumberGenerator.generateRandomNumber()));
            Output.printEachCarDistance(cars);
        }
        winner.makeWinnerNames(cars);
    }

    public Winner getWinner() {
        return winner;
    }

    private boolean isGameContinue() {
        return this.tryCount-- > 0;
    }
}
