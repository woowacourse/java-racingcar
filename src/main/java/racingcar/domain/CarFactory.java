package racingcar.domain;

import java.util.List;
import racingcar.random.NumberGenerator;

public class CarFactory {

    private final NumberGenerator numberGenerator;

    public CarFactory(final NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Car> createCars(final List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(name, new Engine(numberGenerator)))
                .toList();
    }
}
