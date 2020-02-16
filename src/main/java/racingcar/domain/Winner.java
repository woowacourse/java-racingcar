package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final List<String> winners = new ArrayList<>();

    public List<String> findWinners(List<Car> carList) {
        int max = findWinnerPosition(carList);

        carList.stream()
            .filter(car -> car.isWinner(max))
            .forEach(car -> winners.add(car.getName()));

        return winners;
    }

    private int findWinnerPosition(List<Car> cars) {
        return cars.stream()
            .map(Car::getPosition)
            .reduce(Integer::max)
            .orElse(0);
    }

}
