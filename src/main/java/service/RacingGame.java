package service;

import domain.Cars;
import domain.MovableStrategy;
import java.util.List;

public class RacingGame {

    private final MovableStrategy movableStrategy;
    private final Cars cars;
    private int roundNum;


    public RacingGame(MovableStrategy movableStrategy, List<String> carNames, int roundNum) {
        this.movableStrategy = movableStrategy;
        this.cars = Cars.from(carNames);
        this.roundNum = roundNum;
    }

    public void race() {
        cars.forEach(c -> c.move(movableStrategy.doMove()));
    }

    public boolean isContinue() {
        if (roundNum == 0) {
            return false;
        }
        roundNum--;
        return true;
    }

    public Cars getCars() {
        return cars;
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }
}
