package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racing.util.RandomGenerator;

public class Cars {
    private List<Car> cars;

    public Cars(String rawNames) {
        List<String> carNames = stringToList(rawNames);
        validate(carNames);
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
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
        for (String name : string.split(",")) {
            names.add(name.trim());
        }
        return names;
    }

    public void proceedRound() {
        cars.forEach(car -> car.moveForward(RandomGenerator.generate()));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public List<Car> findFurthestCars() {
        Collections.sort(cars);
        return cars.stream().filter((car) -> car.isSame(cars.get(0))).toList();
    }
}
