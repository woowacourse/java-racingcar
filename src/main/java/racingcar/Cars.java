package racingcar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Name> names) {
        this.cars = convertNamesToCars(names);
    }

    private List<Car> convertNamesToCars(List<Name> names) {
        return names.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public void move() {
        cars.forEach(car -> car.advance(RandomUtil.getNumbersInRange(10)));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
