package racingcar.domain;

import racingcar.validator.CarsValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
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
        List<Car> cars = Arrays.stream(carNames).map(Car::of).collect(Collectors.toList());
        return new Cars(cars);
    }

    public void tryToMoveCars(List<Integer> randomNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).tryToMove(randomNumbers.get(i));
        }
    }

    public int size() {
        return cars.size();
    }

    public Result getResultOfCars() {
        List<CarState> carStates = new ArrayList<>();
        for (Car car : this.cars) {
            carStates.add(car.getCarState());
        }
        return Result.of(carStates);
    }

    public List<Car> getCars() {
        return cars;
    }
}
