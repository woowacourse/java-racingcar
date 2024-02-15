package domain;

import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> value;

    private Cars(List<Car> cars) {
        this.value = cars;
    }

    public static Cars from(CarNameCatalog carNameCatalog) {

        List<Car> cars = carNameCatalog.getNames()
                .stream()
                .map(Car::new)
                .toList();

        return new Cars(cars);
    }

    public List<Car> getValue() {
        return Collections.unmodifiableList(value);
    }
}
