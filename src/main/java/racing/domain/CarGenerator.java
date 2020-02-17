package racing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarGenerator {
    public List<Car> carGenerate(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
