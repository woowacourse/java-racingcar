package racingcar.domain.carfactory;

import racingcar.domain.car.Car;
import racingcar.domain.cars.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public Cars createCars(final List<String> carNames) {
        return new Cars(makeCars(carNames));
    }

    private List<Car> makeCars(final List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }
}
