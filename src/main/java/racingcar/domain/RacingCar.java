package racingcar.domain;

import racingcar.view.RacingCarView;

public class RacingCar {
    private Cars cars;
    private TryCount tryCount;

    public RacingCar(Cars cars, TryCount tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void start() {
        raceByTryCount();
    }

    private void raceByTryCount() {
        while (tryCount.isRemainCount()) {
            cars.race();
            RacingCarView.printProgressResult(cars.cars());
            tryCount.deductCount();
        }
    }

    public Winners calculateResult() {
        return new Winners(cars);
    }
}
