package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private static final int MIN_POSITION = 0;
    private static final String DELIMITER = ", ";
    private static final String WINNER_SENTENCE = "가 최종 우승했습니다.";

    private final List<Car> winners;

    public Winners(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public String getWinnersSentence() {
        return String.join(DELIMITER, getNames()) + WINNER_SENTENCE;
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(MIN_POSITION);
    }

    private List<String> getNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
