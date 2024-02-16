package domain;

import java.util.*;

import static util.Exceptions.DUPLICATED_NAME_EXCEPTION;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        validateDuplicatedNames(names);
        cars = createCarsByNames(names);
    }

    private void validateDuplicatedNames(List<String> names) {
        if (names.size() != names.stream().distinct().toList().size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME_EXCEPTION.getMessage());
        }
    }

    private List<Car> createCarsByNames(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public int getMaxForward() {
        return cars.stream().max(Car::compareTo).get().getForward();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
