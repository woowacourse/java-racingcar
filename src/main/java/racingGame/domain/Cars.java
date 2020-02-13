package racingGame.domain;

import racingGame.utils.RandomGenerator;

import java.util.*;

public class Cars {
    private static final int POSITION_INIT = 0;

    private final List<Car> cars;
    private int maximumPosition = POSITION_INIT;

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
        updateMaximumPosition();
    }

    public void updateMaximumPosition() {
        for (Car individualCar : cars) {
            maximumPosition = Math.max(maximumPosition,individualCar.getPosition());
        }
    }

    public List<Car> getWinnersList() {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            addIfWinner(winners, car);
        }
        return winners;
    }

    private void addIfWinner(List<Car> winners, final Car car) {
        if (car.isWinnerPosition(maximumPosition)) {
            winners.add(car);
        }
    }

    private long getDistinctSize(final List<Car> cars) {
        return Arrays.stream(cars.toArray())
                .distinct()
                .count();
    }

    public Collection<Car> getCars() {
        return Collections.unmodifiableCollection(cars);
    }
}
