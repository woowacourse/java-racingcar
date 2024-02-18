package controller;

import model.Car;
import model.Game;
import model.TrialCount;

import java.util.List;

public class RacingCarController {
    private final Game game;
    private final TrialCount trialCount;

    public RacingCarController(List<String> carsName, int trialCount) {
        this.game = new Game(carsName);
        this.trialCount = new TrialCount(trialCount);
    }

    public void run() {
        while (trialCount.isRest()) {
            game.proceed();
            trialCount.reduce();
        }
    }

    public List<Car> getRacingCars() {
        return game.getCars();
    }

    public List<Car> findWinners() {
        return game.findWinners();
    }
}
