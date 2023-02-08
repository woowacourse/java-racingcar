package racingcar.model.car;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
        this.cars = cars;
    }
}
