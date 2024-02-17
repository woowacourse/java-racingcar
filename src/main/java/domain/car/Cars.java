package domain.car;

import domain.name.NameCatalog;

import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> value;

    private Cars(List<Car> cars) {
        this.value = cars;
    }

    public static Cars from(NameCatalog nameCatalog) {
        List<Car> cars = nameCatalog.getNames()
                .stream()
                .map(Car::new)
                .toList();

        return new Cars(cars);
    }

    public List<Car> getValue() {
        return Collections.unmodifiableList(value);
    }
}
