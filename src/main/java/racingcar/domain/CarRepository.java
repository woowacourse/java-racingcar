package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {

    private static final int START_POINT = 0;
    private final List<Car> cars;

    public CarRepository(List<String> carNames) {
        this.cars = createCarsByNames(carNames);
    }

    private List<Car> createCarsByNames(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName, START_POINT))
                .collect(Collectors.toUnmodifiableList());
    }

    public void moveCars(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator));
    }
}
