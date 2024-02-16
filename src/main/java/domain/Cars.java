package domain;

import util.Exceptions;

import java.util.*;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        validateDuplicatedNames(names);
        cars = convertNamesToCars(names);
    }

    private void validateDuplicatedNames(List<String> names) {
        if (names.size() != Set.copyOf(names).size()) {
            throw new IllegalArgumentException(Exceptions.DUPLICATED_NAME_EXCEPTION.getMessage());
        }
    }

    private List<Car> convertNamesToCars(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public int getMaxForward() {
        return cars.stream()
                .max(Comparator.comparing(Car::getForward))
                .orElseThrow()
                .getForward();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

}
