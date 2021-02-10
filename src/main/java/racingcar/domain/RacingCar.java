package racingcar.domain;

import java.util.List;

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

    public List<Car> getNowCars() {
        return this.cars.cars();
    }

    private void raceByTryCount() {
        cars.race();
        tryCount.deductCount();
    }

    public boolean isNotFinish(){
        return tryCount.isRemainCount();
    }

    public Winners calculateResult() {
        return new Winners(cars);
    }
}
