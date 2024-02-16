package racingcar.domain;

import java.util.List;
import racingcar.random.NumberGenerator;

public class CarFactory {

    private final Engine engine;

    public CarFactory(NumberGenerator numberGenerator) {
        this.engine = new Engine(numberGenerator);
    }

    public List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(name, engine))
                .toList();
    }
}
