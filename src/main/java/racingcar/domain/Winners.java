package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    public static final String AND = ", ";

    private static List<String> winners = new ArrayList<>();

    public Winners(Cars cars) {
        this.winners = findWinners(cars);
    }

    public List<String> findWinners(Cars cars) {
        int maxLocation = findMaxLocation(cars);
        List<String> winners = cars.getCars().stream()
                .filter(car -> car.isLocation(maxLocation))
                .map(Car::getName)
                .collect(Collectors.toList());
        return winners;
    }

    public int findMaxLocation(Cars cars) {
        List<Integer> locationOfCars = cars.getCars().stream()
                .map(Car::getLocation)
                .collect(Collectors.toList());
        return Collections.max(locationOfCars);
    }

    public static String getWinnerNames() {
        return String.join(AND, winners);
    }
}