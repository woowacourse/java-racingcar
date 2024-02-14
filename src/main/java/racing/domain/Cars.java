package racing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Cars {
    private final List<Car> cars;

    public Cars(String rawNames) {
        List<String> carNames = stringToList(rawNames);
        validate(carNames);
        List<Car> cars = carNames.stream().map(Car::new).toList();
        this.cars = cars;
    }

    private void validate(List<String> cars) {
        validateDuplicateName(cars);
    }

    private static void validateDuplicateName(List<String> cars) {
        int count = (int) cars.stream().distinct().count();
        if (count != cars.size()) {
            throw new IllegalArgumentException();
        }
    }

    private List<String> stringToList(String string) {
        List<String> names = new ArrayList<>();
        for(String name:string.split(",")){
            names.add(name.trim());
        }
        return names;
    }

}
