package racingcar.service;

import racingcar.domain.Car;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class RacingGame {

    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;
    private static final int FIRST_CAR_INDEX = 0;

    private final List<Car> cars;
    private int count;

    public RacingGame(List<Car> cars, int count) {
        this.cars = cars;
        this.count = count;
    }

    public void playRound() {
        count--;
        for (Car car : cars) {
            car.move(getRandInt());
        }
    }

    public List<Car> findWinners() {
        Car maxPositionCar = getMaxPositionCar();
        return cars.stream()
                .filter(car -> car.isSamePositionWith(maxPositionCar))
                .collect(toList());
    }

    public boolean isGameFinished() {
        return count == 0;
    }

    private Car getMaxPositionCar() {
        List<Car> result = new ArrayList<>(cars);
        result.sort(Comparator.reverseOrder());
        return result.get(FIRST_CAR_INDEX);
    }

    private int getRandInt() {
        return new Random().nextInt(RANDOM_NUMBER_UPPER_BOUND);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
