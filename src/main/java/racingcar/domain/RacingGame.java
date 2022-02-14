package racingcar.domain;


import racingcar.utils.NumberGenerator;

public class RacingGame {

    private final Cars cars;
    private int trialCount;
    private final NumberGenerator numberGenerator;

    public RacingGame(Cars cars, int trialCount, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.trialCount = trialCount;
        this.numberGenerator = numberGenerator;
    }

    public Cars getCars() {
        return cars;
    }

    public void playTurn() {
        cars.moveCars(numberGenerator);
        trialCount--;
    }

    public boolean isFinished() {
        return trialCount == 0;
    }
}
