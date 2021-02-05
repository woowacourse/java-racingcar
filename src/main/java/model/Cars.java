package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        validateUserCount(carNames);
        validateDuplicate(carNames);
        makeCars(carNames);
    }

    public void validateUserCount(List<String> carNames) {
        if (carNames.size() <= 1) {
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplicate(List<String> carNames) {
        if (!carNames.stream().filter(count -> Collections.frequency(carNames, count) > 1).collect(Collectors.toSet()).isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveCars() {
        cars.stream()
                .filter(car -> car.getRandomNumber() >= 4)
                .forEach(car -> car.movePosition());
    }

    public void makeCars(List<String> names) {
        names.stream().forEach(name -> cars.add(new Car(name)));
    }
}
