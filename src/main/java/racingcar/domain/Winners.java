package racingcar.domain;

import racingcar.domain.car.Cars;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    public static final String AND = ", ";

    private final List<String> winners;

    public Winners(Cars cars) {
        int maxLocation = findMaxLocation(cars);
        List<String> winners = findWinners(cars, maxLocation);
        this.winners = winners;
    }

    public int findMaxLocation(Cars cars) {
        List<Integer> locationOfCars = cars.getCars().stream()
                .map(car -> car.getLocation())
                .collect(Collectors.toList());
        return Collections.max(locationOfCars);
    }

    public List<String> findWinners(Cars cars, int maxLocation) {
        List<String> winners = cars.getCars().stream()
                .filter(car -> car.isLocation(maxLocation))
                .map(car -> car.getName())
                .collect(Collectors.toList());
        return winners;
    }

    public String getWinnerNames() {
        return String.join(AND, winners);
    }
}