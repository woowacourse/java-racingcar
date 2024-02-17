package domain.car;

import domain.name.Names;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> value;

    public Cars(List<Car> cars) {
        this.value = cars;
    }

    public static Cars from(Names names) {

        List<Car> cars = names.getNames()
                              .stream()
                              .map(Car::new)
                              .toList();

        return new Cars(cars);
    }

    public List<Car> getMaxPositionCars() {
        Integer maxPosition = getMaxPosition();
        return selectCarsWithPosition(maxPosition);
    }

    private Integer getMaxPosition() {
        return value.
                stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private List<Car> selectCarsWithPosition(Integer position) {
        return
                value.stream()
                     .filter(car -> car.getPosition()
                                       .equals(position))
                     .toList();
    }

    public List<Car> getValue() {
        return Collections.unmodifiableList(value);
    }
}
