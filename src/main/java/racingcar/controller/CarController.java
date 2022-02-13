package racingcar.controller;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Count;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    private static final String DELIMITER = ",";
    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;

    private Count count;

    public void run() {
        String carNames = InputView.getCarNames();

        List<Car> cars = makeCars(carNames);

        int count = getCountFromUser();
        this.count = new Count(count);

        playGame(cars);
        OutputView.printWinners(findWinners(cars));
    }

    private List<Car> makeCars(String carNames) {
        try {
            return makeCars(carNames.split(DELIMITER));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeCars(InputView.getCarNames());
        }
    }

    private void playGame(List<Car> cars) {
        OutputView.printResult(cars);
        for (int i = 0; i < count.getInt(); i++) {
            playRound(cars);
            OutputView.printResult(cars);
        }
    }

    private List<Car> makeCars(String[] names) {
        return Arrays.stream(names).map(CarName::new).map(Car::new).collect(toList());
    }

    private int getCountFromUser() {
        try {
            return InputView.getCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCountFromUser();
        }
    }

    private void playRound(List<Car> cars) {
        for (Car car : cars) {
            car.attemptToMove(getRandInt());
        }
    }

    private int getRandInt() {
        return new Random().nextInt(RANDOM_NUMBER_UPPER_BOUND);
    }

    public List<Car> findWinners(List<Car> cars) {
        Car maxPositionCar = getMaxPositionCar(cars);
        return cars.stream().filter(car -> car.isSamePositionWith(maxPositionCar))
            .collect(toList());
    }

    private Car getMaxPositionCar(List<Car> cars) {
        return cars.stream().max(Car::compareTo).orElseThrow(NoSuchElementException::new);
    }
}
