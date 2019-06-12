package domain;

import exception.RacingGameNoTrialLeftException;

public class RacingGame {
    private Cars cars;
    private Trial trial;

    private RacingGame(Cars cars, Trial trial) {
        this.cars = cars;
        this.trial = trial;
    }

    public static RacingGame of(Cars cars, Trial trial) {
        return new RacingGame(cars, trial);
    }

    public Cars doTrial(MoveStrategy strategy) {
        checkTrial();

        trial = trial.adjust();
        cars = cars.move(strategy);

        return cars;
    }

    private void checkTrial() {
        if (trial.isEmpty()) {
            throw new RacingGameNoTrialLeftException("trial 이 남지 않았습니다");
        }
    }

    public boolean hasTrial() {
        return !trial.isEmpty();
    }

    public Cars findWinners() {
        return cars.findWinners();
    }
}
