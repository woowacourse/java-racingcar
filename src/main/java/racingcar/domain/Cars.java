package racingcar.domain;

import racingcar.util.RandomUtil;
import racingcar.view.Output;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAllByRandom() {
        cars.forEach(car -> car.goForward(RandomUtil.getRandomForCar()));
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

    public void showCarsStatus() {
        for (Car car : cars) {
            Output.printCarStatus(car);
        }
        Output.printBlankLine();
    }

    @Override
    public String toString() {
        return cars.stream()
                .map(car -> car.toString())
                .collect(Collectors.joining("\n"));
    }
}
