package racingcar.model.track;

import racingcar.model.car.Cars;

public class Track {
    private final Cars cars;
    private int trialTime;

    public Track(Cars cars, int trialTime) {
        this.cars = cars;
        this.trialTime = trialTime;
    }


    public Cars race() {
        cars.moveCars();
        removeTrialTimes();
        return cars;
    }

    private void removeTrialTimes() {
        trialTime -= 1;
    }

    public boolean runnable() {
        return trialTime >= 0;
    }

    public Cars findWinner() {
        return cars.getWinnerCars();
    }
}
