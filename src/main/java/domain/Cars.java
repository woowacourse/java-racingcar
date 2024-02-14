package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static util.Exceptions.DUPLICATED_NAME_EXCEPTION;

public class Cars {

    private final List<Car> Cars;

    public Cars(List<String> names) {
        validateDuplicatedNames(names);
        Cars = convertNamesToCars(names);
    }

    private void validateDuplicatedNames(List<String> names) {
        if (names.size() != Set.copyOf(names).size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME_EXCEPTION.getMessage());
        }
    }

    private List<Car> convertNamesToCars(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }
}
