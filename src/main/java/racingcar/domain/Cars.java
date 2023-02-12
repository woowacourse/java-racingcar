package racingcar.domain;

import java.util.*;

import static racingcar.exception.ErrorMessages.CARS_SIZE_EXCEPTION;
import static racingcar.exception.ErrorMessages.CAR_NAME_DUPLICATE_EXCEPTION;

public class Cars {
    private final Set<Car> cars = new LinkedHashSet<>();

    public void generateCars(List<String> carNames) {
        validateCarsSizeOneOrZero(carNames);
        for (String carName : carNames) {
            generateCar(carName);
        }
    }

    public void moveCars() {
        cars.forEach(Car::move);
    }

    public List<String> findWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = findMaxPositionAndWinner(car, maxPosition, winnerNames);
        }

        return winnerNames;
    }

    public void reset() {
        cars.clear();
    }

    public Map<String, Integer> getCarsState() {
        Map<String, Integer> carsState = new HashMap<>();
        for (Car car : cars) {
            carsState.put(car.getName(), car.getPosition());
        }
        return Collections.unmodifiableMap(carsState);
    }

    private void generateCar(String name) {
        Car newCar = new Car(name);
        validateDuplicatedCarName(newCar);
        cars.add(newCar);
    }

    private void validateCarsSizeOneOrZero(List<String> carNames) {
        int carsSize = carNames.size();
        if (carsSize == 0 || carsSize == 1) {
            throw new IllegalArgumentException(CARS_SIZE_EXCEPTION.getMessage());
        }
    }

    private void validateDuplicatedCarName(Car newCar) {
        if (cars.contains(newCar)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_EXCEPTION.getMessage());
        }
    }

    private int findMaxPositionAndWinner(Car car, int currMax, List<String> winnerNames) {
        if (car.getPosition() > currMax) {
            winnerNames.clear();
            winnerNames.add(car.getName());
            return car.getPosition();
        }

        if (car.getPosition() == currMax) {
            winnerNames.add(car.getName());
        }

        return currMax;
    }
}
