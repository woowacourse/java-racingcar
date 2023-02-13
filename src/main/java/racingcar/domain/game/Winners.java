package racingcar.domain.game;

import racingcar.domain.car.Car;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private final List<Car> winners;

    public Winners(final List<Car> cars) {
        this.winners = judgeWinners(cars);
    }

    public List<Car> winners() {
        return winners;
    }

    private List<Car> judgeWinners(final List<Car> cars) {
        Car winner = findWinner(cars);

        return cars.stream()
                .filter(it -> it.isSamePosition(winner))
                .collect(Collectors.toList());
    }

    private Car findWinner(final List<Car> cars) {
        return cars.stream()
                .max(Comparator.comparing(Car::position))
                .orElseThrow(IllegalArgumentException::new);
    }
}
