package racingcar.domain;

import racingcar.utils.RandomUtils;
import racingcar.validator.CarsValidator;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int MIN_RANDOM_RANGE = 0;
    private static final int MAX_RANDOM_RANGE = 9;
    private static final String DELIMITER = ",";

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        CarsValidator.validate(cars);
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars of(String inputCarNames) {
        String[] carNames = inputCarNames.split(DELIMITER);
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(Car.of(name));
        }
        return new Cars(cars);
    }

    public void tryToMove() {
        for (Car car : cars) {
            int randomValue = RandomUtils.nextInt(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE);
            car.tryToMove(randomValue);
        }
    }

    public Result getResultOfCars() {
        List<CarState> carStates = new ArrayList<>();
        for (Car car : cars) {
            carStates.add(car.getCarState());
        }
        return Result.of(carStates);
    }
}
