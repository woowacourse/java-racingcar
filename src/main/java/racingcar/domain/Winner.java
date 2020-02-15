package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private static final List<String> winners = new ArrayList<>();

    private Winner() {
    }

    public static List<String> findWinners(List<Car> carList) {
        int max = findWinnerPosition(carList);

        carList.stream()
            .filter(car -> car.isWinner(max))
            .forEach(car -> winners.add(car.getName()));

        return winners;
    }

    private static int findWinnerPosition(List<Car> cars) {
        return cars.stream()
            .map(Car::getPosition)
            .reduce(Integer::max)
            .orElse(0);
    }

}
