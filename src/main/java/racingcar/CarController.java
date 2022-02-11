package racingcar;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    private static final String DELIMITER = ",";
    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;

    public void run() {
        String carNames = getCarNamesFromUser();
        int count = getCountFromUser();

        List<Car> cars = makeCars(carNames.split(DELIMITER));

        playGame(count, cars);
        OutputView.printWinners(findWinners(cars));
    }

    private void playGame(int count, List<Car> cars) {
        OutputView.printResult(cars);
        for (int i = 0; i < count; i++) {
            playRound(cars);
            OutputView.printResult(cars);
        }
    }

    private List<Car> makeCars(String[] names) {
        return Arrays.stream(names).map(Car::new).collect(toList());
    }

    private int getCountFromUser() {
        try {
            return InputView.getCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCountFromUser();
        }
    }

    private String getCarNamesFromUser() {
        try {
            return InputView.getCarNames();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCarNamesFromUser();
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
