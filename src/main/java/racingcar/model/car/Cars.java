package racingcar.model.car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.AssertUtils;
import racingcar.util.ErrorMessage;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validate(cars);
        this.cars = cars;
    }

    public void moveCars() {
        cars.stream()
                .filter(Car::movable)
                .forEach(Car::moveForward);
    }

    public List<Car> getWinnerCars() {
        int maxPosition = Collections.max(cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList()));

        return cars.stream()
                .filter(car -> car.matchPosition(maxPosition))
                .collect(Collectors.toList());
    }

    private void validate(List<Car> cars) {
        AssertUtils.assertNull(cars);
        validateCarNameDuplication(cars);
    }

    public void validateCarNameDuplication(List<Car> cars) {
        int distinctSize = getDistinctSize(cars);
        if (cars.size() != distinctSize) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATED.message());
        }
    }

    private int getDistinctSize(List<Car> cars) {
        return cars.stream()
                .map(Car::getCarName)
                .collect(Collectors.toSet())
                .size();
    }

    public List<Car> getCars() {
        return cars;
    }
}
