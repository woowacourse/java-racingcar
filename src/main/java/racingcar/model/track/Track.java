package racingcar.model.track;

import racingcar.RacingCarContext;
import racingcar.model.car.Cars;
import racingcar.model.track.formatter.TrackStateFormatter;
import racingcar.model.trialtimes.TrialTimes;

public class Track {
    private static final int END_CONDITION = 0;
    private static final TrackStateFormatter FORMATTER = RacingCarContext.trackStateFormatter();

    private final Cars cars;
    private final TrialTimes trialTimes;

    public Track(Cars cars, TrialTimes trialTimes) {
        this.cars = cars;
        this.trialTimes = trialTimes;
    }

    public void race() {
        cars.moveCars();
        trialTimes.consume();
    }

    public boolean runnable() {
        return trialTimes.isGreaterThan(END_CONDITION);
    }

    public String carsPositionFormat() {
        return FORMATTER.carsPositionFormat(cars);
    }

    public String winingCarsFormat() {
        return FORMATTER.winnerCarsFormat(cars.getWinnerCars());
    }
}
