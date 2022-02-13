package racingcar.domain;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import racingcar.utils.Validator;

public class Cars {
    private static final int RANDOM_NUMBER_UPPER_BOUND = 10;
    private static final String DELIMITER = ",";

    private final Random random = new Random();
    private final List<Car> cars;

    public Cars(String carNames) {
        Validator.checkInput(carNames);
        this.cars = makeCars(carNames);
    }

    protected Cars(List<Car> cars) {
        this.cars = cars;
    }

    private List<Car> makeCars(String carNames) {
        return makeCars(carNames.split(DELIMITER));
    }

    private List<Car> makeCars(String[] names) {
        return Arrays.stream(names).map(CarName::new).map(Car::new).collect(toList());
    }

    public void playRound() {
        for (Car car : cars) {
            car.attemptToMove(random.nextInt(RANDOM_NUMBER_UPPER_BOUND));
        }
    }

    public List<Car> findWinners() {
        Car maxPositionCar = getMaxPositionCar();
        return cars.stream().filter(car -> car.isSamePositionWith(maxPositionCar))
            .collect(toList());
    }

    private Car getMaxPositionCar() {
        return cars.stream().max(Car::compareTo).orElseThrow(NoSuchElementException::new);
    }

    public List<Car> get() {
        return cars;
    }
}
