package racingcar.domain;

import java.util.HashSet;
import java.util.Set;
import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int MIN_RANDOM_RANGE = 0;
    private static final int MAX_RANDOM_RANGE = 9;
    private static final int MIN_CARS_SIZE = 2;
    private static final String DELIMITER = ",";

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateCarsSize(cars);
        validateDuplicatedCarNames(cars);
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars from(String inputCarNames) {
        String[] carNames = inputCarNames.split(DELIMITER);
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(Car.from(name));
        }
        return new Cars(cars);
    }

    private void validateCarsSize(List<Car> cars) {
        if (cars.size() < MIN_CARS_SIZE) {
            throw new IllegalArgumentException("자동차는 2대 이상 이어야 합니다.");
        }
    }

    private void validateDuplicatedCarNames(List<Car> cars) {
        Set<Car> carsSet = new HashSet<>(cars);
        if (cars.size() != carsSet.size()) {
            throw new IllegalArgumentException("자동차 이름이 중복되면 안 됩니다.");
        }
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
        return Result.from(carStates);
    }
}
