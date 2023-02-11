package racingcar.domain.game;

import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private static final int WINNER_INDEX = 0;

    private final List<Car> winners;

    public Winners(final List<Car> cars) {
        this.winners = judgeWinners(cars);
    }

    private List<Car> judgeWinners(final List<Car> cars) {
        List<Car> sortedCarsByPositionDesc = sortedCarsByPositionDesc(cars);
        Car winner = sortedCarsByPositionDesc.get(WINNER_INDEX);

        return sortedCarsByPositionDesc.stream()
                .filter(it -> it.getPosition().equals(winner.getPosition()))
                .collect(Collectors.toList());
    }

    private List<Car> sortedCarsByPositionDesc(final List<Car> cars) {
        List<Car> sortedCars = new ArrayList<>(cars);
        sortedCars.sort(Comparator.comparing(Car::getPosition));
        Collections.reverse(sortedCars);
        return sortedCars;
    }

    public List<Car> winners() {
        return winners;
    }
}
