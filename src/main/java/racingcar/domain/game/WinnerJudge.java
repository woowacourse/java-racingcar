package racingcar.domain.game;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerJudge {

    private static final int WINNER_INDEX = 0;

    public List<Car> judge(final Cars cars) {
        List<Car> sortedCarsByPositionDesc = cars.sortedCarsByPositionDesc();
        Car winner = sortedCarsByPositionDesc.get(WINNER_INDEX);

        return sortedCarsByPositionDesc.stream()
                .filter(it -> it.getPosition().equals(winner.getPosition()))
                .collect(Collectors.toList());
    }
}
