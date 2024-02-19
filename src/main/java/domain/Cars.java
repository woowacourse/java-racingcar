package domain;

import util.Exceptions;

import java.util.*;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        validateDuplicatedNames(names);
        cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private void validateDuplicatedNames(List<String> names) {
        if (names.size() != names.stream().distinct().toList().size()) {
            throw new IllegalArgumentException(Exceptions.DUPLICATED_NAME_EXCEPTION.getMessage());
        }
    }

    public int getMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().orElseThrow();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

}
