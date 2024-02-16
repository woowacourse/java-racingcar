package racing.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racing.util.RandomGenerator;

public class Cars {

    private final List<Car> cars;

    public Cars(String rawNames) {
        List<String> carNames = parseNames(rawNames);
        validate(carNames);
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    private void validate(List<String> cars) {
        validateDuplicateName(cars);
    }

    private void validateDuplicateName(List<String> cars) {
        int count = (int) cars.stream().distinct().count();
        if (count != cars.size()) {
            throw new IllegalArgumentException();
        }
    }

    private List<String> parseNames(String names) {
        return Arrays.stream(names.split(",")).map(String::trim).toList();
    }

    public void proceedRound() {
        cars.forEach(car -> car.moveByNumber(RandomGenerator.generate()));
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n", "", "\n"));
    }

    public List<Car> findFurthestCars() {
        Collections.sort(cars);
        return cars.stream().filter((car) -> car.isSame(cars.get(0))).toList();
    }
}
