package racingcar.service;

import racingcar.domain.Car;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static java.util.stream.Collectors.toList;

public class RacingGame {

    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;
    private static final int FIRST_CAR_INDEX = 0;

    private final List<Car> cars;
    private final int count;
    public RacingGame(List<Car> cars, int count) {
        this.cars = cars;
        this.count = count;
    }

    public void play() {
        OutputView.printResult(cars);
        for (int i = 0; i < count; i++) {
            playRound();
            OutputView.printResult(cars);
        }
    }

    public List<Car> findWinners() {
        Car maxPositionCar = getMaxPositionCar();
        return cars.stream()
                .filter(car -> car.isSamePositionWith(maxPositionCar))
                .collect(toList());
    }

    private void playRound() {
        for (Car car : cars) {
            car.attemptToMove(getRandInt());
        }
    }

    private Car getMaxPositionCar() {
        List<Car> result = new ArrayList<>(cars);
        result.sort(Comparator.reverseOrder());
        return result.get(FIRST_CAR_INDEX);
    }

    private int getRandInt() {
        return new Random().nextInt(RANDOM_NUMBER_UPPER_BOUND);
    }
}
