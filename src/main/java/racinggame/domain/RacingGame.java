package racinggame.domain;

import racinggame.utils.RandomNumberGenerator;

import java.util.List;

public class RacingGame {
    private final Winner winner;
    private List<Car> cars;
    private int tryCount;

    public RacingGame(List<Car> cars, int tryCount) {
        winner = new Winner();
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void run() {
        while (isGameContinue()) {
            cars.forEach(car -> car.move(RandomNumberGenerator.generateRandomNumber()));
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
