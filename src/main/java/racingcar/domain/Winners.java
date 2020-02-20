package racingcar.domain;

import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    public static final String AND = ", ";

    private static List<String> winners = new ArrayList<>();

    public Winners(List<Car> cars) {
        this.winners = findWinners(cars);
    }

    public List<String> findWinners(List<Car> cars) {
        int maxLocation = findMaxLocation(cars);
        List<String> winners = cars.stream()
                .filter(car -> car.isMaxLocation(maxLocation))
                .map(Car::getName)
                .collect(Collectors.toList());
        return winners;
    }

    public int findMaxLocation(List<Car> cars) {
        List<Integer> locationOfCars = cars.stream()
                .map(Car::getLocation)
                .collect(Collectors.toList());
        return Collections.max(locationOfCars);
    }

    public static String getWinnerNames() {
        return String.join(AND, winners);
    }
}