package racingGame.domain;

import racingGame.utils.RandomGenerator;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private static final int POSITION_INIT = 0;
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        checkDuplicate(cars);
        this.cars = cars;
    }

    private void checkDuplicate(final List<Car> cars) {
        if (cars.size() != getDistinctSize(cars)) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    public void moveCars() {
        for (Car individualCar : cars) {
            individualCar.move(RandomGenerator.generateRandomNumber());
        }
    }

    public int getMaximumPosition() {
        int maxPosition = POSITION_INIT;

        for (Car individualCar : cars) {
            maxPosition = getBigger(maxPosition, individualCar.getPosition());
        }
        return maxPosition;
    }

    private int getBigger(int maxPosition, int position) {
        if (maxPosition < position) {
            return position;
        }
        return maxPosition;
    }

    private long getDistinctSize(final List<Car> cars) {
        return Arrays.stream(cars.toArray())
                .distinct()
                .count();
    }

    public List<Car> getCars() {
        return cars;
    }
}
