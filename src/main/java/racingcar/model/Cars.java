package racingcar.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.generator.NumberGenerator;

public class Cars {

    private final List<Car> cars;
    private final NumberGenerator generator;

    public Cars(List<Car> cars, NumberGenerator generator) {
        validateCarNames(cars);
        this.cars = cars;
        this.generator = generator;
    }

    public LinkedHashMap<String, Integer> makeCarsMove() {
        LinkedHashMap<String, Integer> carStatus = new LinkedHashMap<>();
        for (Car car : cars) {
            car.move(generator.generate());
            String carName = car.getName();
            int position = car.getPosition();
            carStatus.put(carName, position);
        }
        return carStatus;
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
