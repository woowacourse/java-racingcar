package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.ui.RacingCarOutput;
import racingcar.utils.RandomIntegerGenerator;

public class RacingGame {
    private static final int MIN_POSITION = 0;
    private static final int START_RANDOM_NUMBER = 0;
    private static final int END_RANDOM_NUMBER = 9;
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> race() {
        cars.forEach(
                (car) -> car.proceed(RandomIntegerGenerator.random(START_RANDOM_NUMBER, END_RANDOM_NUMBER))
        );

        return cars;
    }

    public List<Car> findWinners() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = findMaxPosition();
        cars.forEach((car) -> addWinner(winners, maxPosition, car));
        return winners;
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(MIN_POSITION);
    }

    private void addWinner(List<Car> winners, int maxPosition, Car car) {
        if (car.isWinner(maxPosition)) {
            winners.add(car);
        }
    }
}
