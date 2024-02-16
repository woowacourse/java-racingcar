package racingcar.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateCarNames(cars);
        this.cars = cars;
    }

    public void makeCarMove(RandomNumberGenerator generator) {
        cars.forEach(car -> car.move(generator.generate()));
    }

    public RoundResult getRoundResult() {
        LinkedHashMap<String, Integer> carStatus = new LinkedHashMap<>();
        for (Car car : cars) {
            carStatus.put(car.getName(), car.getPosition());
        }
        return new RoundResult(carStatus);
    }

    private void validateCarNames(List<Car> cars) {
        Set<String> distinctNames = cars.stream()
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableSet());
        if (distinctNames.size() != cars.size()) {
            throw new IllegalArgumentException();
        }
    }
}
