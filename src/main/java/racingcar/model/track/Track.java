package racingcar.model.track;

import racingcar.model.car.Cars;

public class Track {
    private final Cars cars;
    private final int trialTime;

    public Track(Cars cars, int trialTime) {
        this.cars = cars;
        this.trialTime = trialTime;
    }


    public void race() {
        for (int i = 0; i < trialTime; i++) {
            cars.moveCars();
        }
    }
}
