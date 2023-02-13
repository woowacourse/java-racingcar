package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {

    private static final int DEFAULT_MAX = 0;

    private final List<Winner> winners;

    public Winners(Cars cars) {
        this.winners = calculateWinners(cars);
    }

    private List<Winner> calculateWinners(Cars cars) {
        int winnerPosition = cars.getCars().stream()
                .mapToInt(car -> car.getPosition().getPosition())
                .max()
                .orElse(DEFAULT_MAX);

        return cars.getCars().stream()
                    .filter(car -> car.getPosition().getPosition() == winnerPosition)
                    .map(car -> new Winner(car.getCarName()))
                    .collect(Collectors.toUnmodifiableList());
    }

    public List<Winner> getWinners() {
        return winners;
    }

}
