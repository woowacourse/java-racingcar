package racingcargame.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {
    private static final String DELIMITER = ",";

    private final List<String> winnerResult;

    public Winner(List<Car> cars) {
        this.winnerResult = findWinner(cars);
    }

    private List<String> findWinner(List<Car> cars) {
        int maxPosition = maxPosition(cars);
        return cars.stream()
                .filter(car -> car.matchPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int maxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(-1);
    }

    @Override
    public String toString() {
        return String.join(DELIMITER, winnerResult);
    }
}
