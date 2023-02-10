package racingcar.domain;

import racingcar.validator.CarValidator;
import racingcar.validator.DefaultCarValidator;

import java.util.*;

import static racingcar.exception.ErrorMessages.CAR_NAME_DUPLICATE_EXCEPTION;

public class Cars {
    private final Set<Car> cars = new LinkedHashSet<>();

    public void createCars(List<String> carNames, NumberGenerator numberGenerator) {
        CarValidator validator = new DefaultCarValidator();
        validator.validateCarNamesSize(carNames);

        CarMovement carMovement = new CarMovement(numberGenerator);
        for (String carName : carNames) {
            generateCar(carName, carMovement);
        }
    }

    public void moveCars() {
        cars.forEach(Car::move);
    }

    public List<String> findWinnerNames() {
        List<String> winnerNames = new ArrayList<>();
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winnerNames.add(car.getName());
            }
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winnerNames.clear();
                winnerNames.add(car.getName());
            }
        }
        return winnerNames;
    }

    public Set<Car> getCars() {
        return Collections.unmodifiableSet(cars);
    }

    private void generateCar(String name, CarMovement carMovement) {
        Car newCar = new Car(name, carMovement);
        validateDuplicatedCarName(newCar);
        cars.add(newCar);
    }

    private void validateDuplicatedCarName(Car newCar) {
        if (cars.contains(newCar)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_EXCEPTION.getMessage());
        }
    }
}
