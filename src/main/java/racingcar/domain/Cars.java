package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.Converter;

public class Cars {
    private final List<Car> cars;

    public Cars(String carNames) {
        this.cars = Converter.stringToCars(carNames);
    }

    public List<String> getWinnerNames() {
        Car winner = cars.stream().max(Car::compareTo).get();

        return cars.stream()
                .filter(car -> car.compareTo(winner) == 0)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void moveCars(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generate()));
    }

    public List<Car> getCars() {
        return this.cars;
    }

}
