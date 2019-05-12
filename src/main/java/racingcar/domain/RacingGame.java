package racingcar.domain;

import racingcar.domain.Rule.MoveRule;

import java.util.*;

public class RacingGame {
    private static final int MIN_NUMBER_OF_CARS = 1;
    private static final int MIN_TRY_COUNT = 1;

    private List<Car> cars = new ArrayList<>();
    private int tryCount;

    public RacingGame(String[] carNames, int tryCount) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        checkMinNumberOfCars();

        checkMinTryCount(tryCount);
        this.tryCount = tryCount;
    }

    private void checkMinNumberOfCars() {
        if (cars.size() < MIN_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("최소 등록 자동차 수는" + MIN_NUMBER_OF_CARS + "입니다.");
        }
    }

    private void checkMinTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("최소 시도 횟수는 " + MIN_TRY_COUNT + "입니다.");
        }
    }

    public List<RaceResult> raceAll() {
        List<RaceResult> eachTryCars = new ArrayList<>();

        for (int i = 0; i < tryCount; i++) {
            eachTryCars.add(race());
        }
        return eachTryCars;
    }

    private RaceResult race() {
        RaceResult raceResult = new RaceResult();

        for (Car car : this.cars) {
            raceResult.add(car.move(new MoveRule()));
        }
        return raceResult;
    }
}
