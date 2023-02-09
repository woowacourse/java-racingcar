package racingcar.step.context;

import racingcar.domain.Cars;
import racingcar.domain.Lap;

public class GameContext {
    private Cars cars;
    private Lap lap;

    public Cars getCars() {
        if (cars == null) {
            throw new IllegalStateException();
        }
        return cars;
    }

    public void setCars(final Cars cars) {
        this.cars = cars;
    }

    public Lap getLap() {
        if (lap == null) {
            throw new IllegalStateException();
        }
        return lap;
    }

    public void setLap(final Lap lap) {
        this.lap = lap;
    }
}
