package racingcar.domain;

import static racingcar.constants.output.ErrorOutputMessages.ERROR_CARS_EMPTY;
import static racingcar.util.ValidatorUtils.validateNoDuplicates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames) {
        validateNoDuplicates(carNames);

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void race(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.goOrNot(moveStrategy);
        }
    }

    public List<Car> findWinners() {
        Car carMaxPosition = getCarMaxPosition();

        return cars.stream()
                .filter(car -> car.isSamePosition(carMaxPosition))
                .collect(Collectors.toList());
    }

    private Car getCarMaxPosition() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(ERROR_CARS_EMPTY));
    }

    public List<Car> findAllCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars targetCars = (Cars) o;
        return Objects.equals(cars, targetCars.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
