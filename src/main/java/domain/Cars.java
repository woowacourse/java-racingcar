package domain;

import java.util.*;
import java.util.stream.Collectors;

import static util.Exceptions.DUPLICATED_NAME_EXCEPTION;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> names) {
        validateDuplicatedNames(names);
        cars = convertNamesToCars(names);
    }

    private void validateDuplicatedNames(List<String> names) {
        if (names.size() != Set.copyOf(names).size()) {
            throw new IllegalArgumentException(DUPLICATED_NAME_EXCEPTION.getMessage());
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private List<Car> convertNamesToCars(List<String> names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    //TODO : getter를 없앨 수는 없을까 ㅜㅜ
    public int getMaxForward() {
        return cars.stream()
                .sorted(Car::compareTo)
                .toList()
                .get(0)
                .getForward();
    }
}
