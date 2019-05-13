package racingcar.domain;

import racingcar.constant.Utils;

import java.util.*;

public class RacingGame {
    private static final int MIN_TRY_COUNT = 1;
    private static final int RANDOM_NUMBER_COUNT = 9;
    private static final int RANDOM_NUMBER_LOWER_BOUND = 1;
    private static final String SPLIT_REGEX = ",";

    private List<Car> cars = new ArrayList<>();
    private int tryCount = MIN_TRY_COUNT;

    public RacingGame(String carNames) {
        this(carNames, MIN_TRY_COUNT);
    }

    public RacingGame(String carNames, int tryCount) {
        generateCarList(carNames);
        configureTryCount(tryCount);
    }

    private void configureTryCount(int tryCount) {
        checkMinTryCount(tryCount);
        this.tryCount = tryCount;
    }

    private void generateCarList(String carNames) {
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

    private void checkMinTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("최소 입력 횟수는 " + MIN_TRY_COUNT + "입니다.");
        }
    }

    public List<Car> race() {
        List<Car> racingResult = new ArrayList<>();
        for (Car car : cars) {
            randomMove(car);
            racingResult.add(new Car(car));
        }
        return racingResult;
    }

    private void randomMove(Car car) {
        int randomNumber = Utils.RANDOM.nextInt(RANDOM_NUMBER_COUNT) + RANDOM_NUMBER_LOWER_BOUND;

        car.move(randomNumber);
    }

    public boolean isZeroTryCount() {
        return tryCount == 0;
    }

    public void subtractTryCount() {
        tryCount--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return tryCount == that.tryCount &&
                Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, tryCount);
    }
}
