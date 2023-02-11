package racingcar.model.track;

import java.util.List;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.trialtimes.TrialTimes;

public class Track {
    private final Cars cars;
    private final TrialTimes trialTimes;

    public Track(Cars cars, TrialTimes trialTimes) {
        this.cars = cars;
        this.trialTimes = trialTimes;
    }

    public Cars race() {
        cars.moveCars();
        trialTimes.consume();
        return cars;
    }

    public boolean runnable() {
        return trialTimes.isGreaterThan(0);
    }

    public List<Car> findWinner() {
        return cars.getWinnerCars();
    }
}
