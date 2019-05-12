package racingcar.domain;

import racingcar.constant.Utils;

import java.util.*;

public class RacingGame {
    private static final int MIN_TRY_COUNT = 1;
    private static final int RANDOM_NUMBER_COUNT = 9;
    private static final int RANDOM_NUMBER_LOWER_BOUND = 1;
    private static final String SPLIT_REGEX = ",";

    private ArrayList<Car> cars = new ArrayList<>();
    private int tryCount = MIN_TRY_COUNT;

    public RacingGame(String carNames) {
        this(carNames, MIN_TRY_COUNT);
    }
    public RacingGame(String carNames, int tryCount) {
        generateCarList(carNames);
        configureTryCount(tryCount);
    }

    public void generateCarList(String carNames) {
        carNames = removeWhiteSpace(carNames);
        checkContinuousComma(carNames);

        for (String carName : splitCarNames(carNames)) {
            cars.add(new Car(carName));
        }
    }

    private String removeWhiteSpace(String carNames) {
        return carNames.trim();
    }

    private void checkContinuousComma(String carNames) {
        if (carNames.contains(",,")) {
            throw new IllegalArgumentException("연속된 콤마가 발견 되었습니다.");
        }
    }

    private String[] splitCarNames(String carNames) {
        return carNames.split(SPLIT_REGEX);
    }

    public void configureTryCount(int tryCount) {
        checkMinTryCount(tryCount);
        this.tryCount = tryCount;
    }

    private void checkMinTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("최소 입력 횟수는 " + MIN_TRY_COUNT + "입니다.");
        }
    }

    public ArrayList<ArrayList<Car>> raceAll() {
        ArrayList<ArrayList<Car>> eachTryCars = new ArrayList<>();

        for (int i = 0; i < tryCount; i++) {
            race();
            eachTryCars.add(cars);
        }
        return eachTryCars;
    }

    private void race() {
        for (Car car : cars) {
            randomMove(car);
        }
    }

    private void randomMove(Car car) {
        int randomNumber = Utils.RANDOM.nextInt(RANDOM_NUMBER_COUNT) + RANDOM_NUMBER_LOWER_BOUND;

        car.move(randomNumber);
    }
}
