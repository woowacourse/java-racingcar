package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.goForward(moveStrategy.generateNumber()));
    }

    public List<Car> findAllWinners() {
        return cars.stream()
                .filter(car -> car.isAlsoWinner(findOneWinner()))
                .collect(Collectors.toList());
    }

    private Car findOneWinner() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition)).get();
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(car -> car.toString())
                .collect(Collectors.joining("\n"));
    }
}
