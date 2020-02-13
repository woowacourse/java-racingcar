package racingcar.domain;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private static final String AND = ", ";

    private final List<Car> winners;

    public Winners(Cars cars) {
        Car carAtMaxLocation = findCarAtMaxLocation(cars);
        List<Car> winners = findWinners(cars, carAtMaxLocation);
        this.winners = winners;
    }

    public Car findCarAtMaxLocation(Cars cars) {
        return Collections.max(cars.getCars());
    }

    public List<Car> findWinners(Cars cars, Car carAtMaxLocation) {
        List<Car> winners = cars.getCars().stream()
                .filter(car -> car.isAtSameLocation(carAtMaxLocation))
                .collect(Collectors.toList());
        return winners;
    }

    public String getWinnersName() {
        List<String> winnerNames = winners.stream()
                .map(winner -> winner.toString())
                .collect(Collectors.toList());

        return String.join(AND, winnerNames);
    }
}