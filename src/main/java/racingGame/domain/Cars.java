package racingGame.domain;

import racingGame.utils.RandomNumberGenerator;

import java.util.*;

public class Cars {
    private static final int INIT_POSITION = 0;

    private final List<Car> cars;
    private int maximumPosition = INIT_POSITION;

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
        cars.stream().forEach(car -> car.move(new RandomNumberGenerator()));
    }

    public int getMaximumPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .get()
                .getPosition();
    }

    public List<Car> getWinnersList() {
        List<Car> winners = new ArrayList<>();

        cars.forEach(car -> addIfWinner(winners, car));
        return winners;
    }

    private void addIfWinner(List<Car> winners, final Car car) {
        if (car.isSamePosition(getMaximumPosition())) {
            winners.add(car);
        }
    }

    private long getDistinctSize(final List<Car> cars) {
        return Arrays.stream(cars.toArray())
                .distinct()
                .count();
    }

    public Collection<Car> getCars() {
        return cars;
    }
}
