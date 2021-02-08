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
        for (int i = 0; i < tryCount.getCount(); i++) {
            race();
            RacingCarView.printProgressResult(cars.cars());
        }
    }

    private void race() {
        for (Car car : cars.cars()) {
            car.moveForward();
        }
    }

    public Winners calculateResult() {
        return new Winners(cars);
    }
}
