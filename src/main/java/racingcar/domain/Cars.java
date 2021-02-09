package racingcar.domain;

import racingcar.utils.RandomUtils;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(Racers racers) {
        this.cars = generateCars(racers);
    }

    private List<Car> generateCars(Racers racers) {
        return racers.streams()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Car getMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .get();
    }

    public List<Car> getWinnerCars(Car maxPositionCar) {
        return cars.stream()
                .filter(car -> car.hasSamePositionWith(maxPositionCar))
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.movePosition(RandomUtils.generateRandomValue());
            OutputView.printCurrentResult(car);
        }
    }
}
