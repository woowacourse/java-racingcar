package racingcar.domain;

import java.util.List;
import racingcar.random.NumberGenerator;

public class CarFactory {

    private final NumberGenerator numberGenerator;

    public CarFactory(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(name, buildEngine()))
                .toList();
    }

    private Engine buildEngine() {
        return new Engine(numberGenerator);
    }
}
