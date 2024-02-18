package domain;

import java.util.List;

public class Winners {
    private final List<String> winners;

    private Winners(final List<String> winners) {
        this.winners = winners;
    }

    public static Winners from(final Cars cars) {
        return new Winners(findWinners(cars).stream()
                .map(Car::getName)
                .toList());
    }

    private static List<Car> findWinners(final Cars cars) {
        int maxPosition = getMaxPosition(cars);
        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();

    }

    private static int getMaxPosition(final Cars cars) {
        return cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();
    }

    public List<String> getWinners() {
        return winners;
    }
}
