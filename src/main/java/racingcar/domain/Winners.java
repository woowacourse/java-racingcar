package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private static final String DELIMITER = ", ";

    private final List<Winner> winners;

    public Winners(Cars cars) {
        int winnerPosition = cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        this.winners = cars.getCars().stream()
                    .filter(car -> car.getPosition() == winnerPosition)
                    .map(car -> new Winner(car.getName()))
                    .collect(Collectors.toUnmodifiableList());
    }

    public List<Winner> getWinners() {
        return winners;
    }

    public String toString() {

        return winners.stream()
                .map(Winner::getName)
                .collect(Collectors.joining(DELIMITER));
    }
}
