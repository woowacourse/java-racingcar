package racingcar.domain;

import racingcar.domain.car.Car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    public static int findMaxPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Comparator.naturalOrder())
                .get();
    }

    public static List<Car> getWinners(List<Car> cars) {
        int maxPosition = Referee.findMaxPosition(cars);
        List<Car> winners = cars.stream()
                .filter(car -> car.isAt(maxPosition))
                .collect(Collectors.toList());

        return winners;
    }
}