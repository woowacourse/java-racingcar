package racingcar.model.track;

import racingcar.model.car.Cars;
import racingcar.validator.TrialTimesValidator;

public class Track {
    private static final int ONE_GAME = 1;
    private static final int CAN_GAME = 0;

    private final Cars cars;
    private int trialTime;

    public Track(Cars cars, String trialTime) {
        TrialTimesValidator.validate(trialTime);

        this.cars = cars;
        this.trialTime = Integer.parseInt(trialTime);
    }

    public Cars race() {
        cars.moveCars();
        removeTrialTimes();
        return cars;
    }

    private void removeTrialTimes() {
        trialTime -= ONE_GAME;
    }

    public boolean runnable() {
        return trialTime >= CAN_GAME;
    }

    public Cars findWinner() {
        return cars.getWinnerCars();
    }
}
