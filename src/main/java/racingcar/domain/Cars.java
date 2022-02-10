package racingcar.domain;

import racingcar.view.Output;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(String[] names) {
        cars = new ArrayList<>();
        for (String name : names) {
            cars.add(createCar(name.trim()));
        }
    }

    public void play() {
        for (Car car : cars) {
            car.drive();
        }
        Output.roundResult(cars);
    }

    private Car createCar(String name) {
        return new Car(name);
    }

    public List<String> findWinners() {
        Car maxPosition = findMaxPosition();
        return findWinnerPosition(maxPosition);
    }

    private Car findMaxPosition() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new NoSuchElementException("max 값을 찾을 수 없습니다."));
    }

    private List<String> findWinnerPosition(Car maxPositionCar) {
        return cars.stream()
                .filter(car -> car.isSamePosition(maxPositionCar))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
