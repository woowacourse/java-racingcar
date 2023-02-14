package racinggame.domain;

import racinggame.utils.NumberGenerator;

import java.util.List;

public class RacingGame {
    private final NumberGenerator randomNumberGenerator;
    private final Winner winner;
    private final List<Car> cars;
    private int tryCount;

    public RacingGame(List<Car> cars, int tryCount, NumberGenerator randomNumberGenerator) {
        winner = new Winner();
        this.cars = cars;
        this.tryCount = tryCount;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void run() {
        while (isGameContinue()) {
            cars.forEach(car -> car.move(randomNumberGenerator.generateNumber()));
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
