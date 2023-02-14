package racingcar.domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Winners {

    private static final int DEFAULT_MAX = 0;

    private final List<Winner> winners;

    public Winners(Cars cars) {
        this.winners = calculateWinners(cars);
    }

    private List<Winner> calculateWinners(Cars cars) {
        int winnerPosition = getWinnerPosition(cars);

        return cars.getCars().stream()
                    .filter(isSamePosition(winnerPosition))
                    .map(Car::getCarName)
                    .map(Winner::new)
                    .collect(Collectors.toUnmodifiableList());
    }

    private int getWinnerPosition(Cars cars) {
        return cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(DEFAULT_MAX);
    }

    private Predicate<Car> isSamePosition(int winnerPosition) {
        return car -> car.getPosition() == winnerPosition;
    }

    public List<Winner> getWinners() {
        return winners;
    }

}
