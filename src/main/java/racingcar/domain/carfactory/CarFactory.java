package racingcar.domain.carfactory;

import racingcar.domain.car.Car;
import racingcar.domain.cars.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    private static final int DEFAULT_POSITION = 0;

    public Cars createCars(List<String> carNames) {
        return new Cars(makeCars(carNames));
    }

    private List<Car> makeCars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName, DEFAULT_POSITION))
                .collect(Collectors.toUnmodifiableList());
    }
}
